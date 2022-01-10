package com.example.diwakar.jwtservice.repo;

import com.example.diwakar.jwtservice.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
