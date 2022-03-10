package ru.ydubovitsky.bowshop.security.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ydubovitsky.bowshop.security.model.AppUser;
import ru.ydubovitsky.bowshop.security.model.enums.AppUserRole;

import java.util.Optional;
import java.util.Set;

@Service("mock")
@AllArgsConstructor
public class AppUserDaoMockImpl implements AppUserDao {

    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<AppUser> getAppUserByUsername(String username) {
        AppUser appUser = AppUser.builder()
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isEnabled(true)
                .username("u")
                .password(passwordEncoder.encode("u"))
                .roles(Set.of(AppUserRole.ADMIN, AppUserRole.USER, AppUserRole.MANAGER))
                .build();

        return Set.of(appUser)
                .stream()
                .filter(user -> username.equals(user.getUsername()))
                .findFirst();
    }
}
