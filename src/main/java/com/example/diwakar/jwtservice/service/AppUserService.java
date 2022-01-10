package com.example.diwakar.jwtservice.service;

import com.example.diwakar.jwtservice.models.AppUser;
import com.example.diwakar.jwtservice.models.Role;

import java.util.List;

public interface AppUserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    AppUser getUser(String username);

    List<AppUser> getUsers();

}
