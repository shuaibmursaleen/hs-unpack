package com.shuaib.hscodes.security.user;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomUserRepository extends MongoRepository<CustomUser, String> {
        Optional<CustomUser> findByUsername(String username);

}