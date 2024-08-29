package com.example.user_profile.service.impl;

import jakarta.annotation.Nonnull;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Nonnull
    @Override
    public Optional<String> getCurrentAuditor() {

        return Optional.of("system");

    }

}
