package com.example.demo.entities.auditor;

import com.example.demo.security.utils.AuthenticationUtils;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;
import java.util.UUID;

/**
 * Classe di utilità per la gestione del settaggio del utente durante una creazione o modifica
 */

public class AuditorAwareImpl implements AuditorAware<UUID> {

    @Override
    public Optional<UUID> getCurrentAuditor() {
        return Optional.ofNullable(AuthenticationUtils.getUserId());
    }
}
