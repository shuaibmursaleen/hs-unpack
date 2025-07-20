package com.shuaib.hscodes.security.dto;

import lombok.Data;

@Data
public class UserVerifyDTO {
    private String email;
    private String verificationCode;
}
