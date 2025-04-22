package com.shuaib.hscodes.security.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Data
@Document("users")
public class CustomUser {
    
    @Id
    private final String id;

    @NonNull 
    private String username;

    @NonNull
    private String password;
}
