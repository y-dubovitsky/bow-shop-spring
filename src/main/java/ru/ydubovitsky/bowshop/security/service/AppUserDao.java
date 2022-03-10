package ru.ydubovitsky.bowshop.security.service;

import ru.ydubovitsky.bowshop.security.model.AppUser;

import java.util.Optional;

public interface AppUserDao {

    Optional<AppUser> getAppUserByUsername(String username);

}
