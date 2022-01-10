package com.example.diwakar.jwtservice.service;

import com.example.diwakar.jwtservice.models.AppUser;
import com.example.diwakar.jwtservice.models.Role;
import com.example.diwakar.jwtservice.repo.AppUserRepo;
import com.example.diwakar.jwtservice.repo.RoleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepo appUserRepo;
    private final RoleRepo roleRepo;

    @Override
    public AppUser saveUser(AppUser user) {
        log.info("Saving user to the database");
        return appUserRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving role to the database");
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);

        appUser.getRoles().add(role);

    }

    @Override
    public AppUser getUser(String username) {

        return appUserRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {

        return appUserRepo.findAll();
    }
}
