package com.example.thymeLeaf.Model;

import jdk.jfr.DataAmount;
import lombok.*;
import org.springframework.stereotype.Service;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private int roll;
    private String name;
    private String email;
}
