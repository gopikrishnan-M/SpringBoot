package com.kris.SecurityDemo.Dto;

import lombok.*;
import org.springframework.context.annotation.Bean;

//now for this project dto is not require lets use it when ever required

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int id;
    private String Username;

}
