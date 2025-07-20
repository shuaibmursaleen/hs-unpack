package com.shuaib.hscodes.security.response;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private long expiry;

    public LoginResponse(String token, long expiry) {
        this.token = token;
        this.expiry = expiry;
    }
}
