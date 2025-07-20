package com.shuaib.hscodes.security.dto;

import lombok.Data;

@Data
public class UserRegisterDTO {
    private String email;
    private String password;
    private String username;
}
