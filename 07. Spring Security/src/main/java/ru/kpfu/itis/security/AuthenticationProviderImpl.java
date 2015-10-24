package ru.kpfu.itis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;


public class AuthenticationProviderImpl implements AuthenticationProvider {

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Qualifier("userRepository")
    @Autowired
    UserRepository repository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        User user = repository.findOneByUsername(login);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        String password = authentication.getCredentials().toString();

        if (!encoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Passwprd is incorrect");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new UsernamePasswordAuthenticationToken(user, null, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
