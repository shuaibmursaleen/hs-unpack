package com.shuaib.hscodes.security.dto;

import lombok.Data;

@Data
public class UserLoginDTO {
    private String email;
    private String password;
}
