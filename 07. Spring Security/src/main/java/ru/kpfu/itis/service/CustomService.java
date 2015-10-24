package ru.kpfu.itis.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
public class CustomService {

    @Secured(value = "hasRole('ROLE_USER')")
    public void method() {

    }

}
