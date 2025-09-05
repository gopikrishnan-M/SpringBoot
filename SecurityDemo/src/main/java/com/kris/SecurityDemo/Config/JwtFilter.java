package com.kris.SecurityDemo.Config;

import com.kris.SecurityDemo.Service.JWTService;
import com.kris.SecurityDemo.Service.UserAuthenticationService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

    //this is a class that will be executed once for every request
@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
        ApplicationContext context;//basics used to get beans from the spring pool

    @Autowired
        JWTService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //behind the scene every thing is servelet here we are going to work with request
        //from the client side we are sending a request along with the jwt token
        //the token will be in the below format
        // Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdXZlIiwiaWF0IjoxNzU3MDY5MjU4LCJleHAiOjE3NTcwNjkzNjZ9.Rta5xHJf4-WcYusWcVuQPVSYwBwE50vRoiHymr_NkS0
        //the header will have the request which has this bearer along with token we will get tat as string
        String authHeader=request.getHeader("Authorization");
        String token=null;
        String username=null;

        if(authHeader !=null && authHeader.startsWith("Bearer ")){
            token=authHeader.substring(7);
            username=jwtService.extractUserName(token);
        }
        //if the security context holder is not null then it is
        // already authenticated so only if it is null we authenticate
        if(username!=null && SecurityContextHolder.getContext() == null){
            UserDetails userDetails=context.getBean(UserAuthenticationService.class).loadUserByUsername(username);
            //the above statement upon giving the username ,fire the database and give the complete data of user
            if (jwtService.validateToken(token, userDetails)) {
                //this means now the token is valid now let's validate the password
                //upa will ask you for 3 things principle ,credentials ,authorities
                UsernamePasswordAuthenticationToken upatoken=
                        new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                upatoken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(upatoken);

            }
        }
        filterChain.doFilter(request,response);
    }
}
