package com.tecgurus.useraccounts.app.runner;

import com.tecgurus.useraccounts.common.util.Constants;

import com.tecgurus.useraccounts.app.dto.gender_reference.GenderReferenceDTO;
import com.tecgurus.useraccounts.app.dto.validation.InvalidPasswordDTO;

import com.tecgurus.useraccounts.app.service.GenderReferenceService;
import com.tecgurus.useraccounts.app.service.validation.PasswordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.boot.CommandLineRunner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BaseDataRunner implements CommandLineRunner {

    // Required services to create initial values
    private final PasswordService passwordService;
    private final GenderReferenceService genderReferenceService;

    @Override
    public void run(String... args) {

        // Create invalid passwords
        Constants.INVALID_PASSWORDS.stream().map(InvalidPasswordDTO::new)
                .forEach(ip -> log.info("Invalid password created: {}", passwordService.createInvalidPassword(ip)));

        // Create the default gender references
        Constants.GENDER_REFERENCES.stream().map(GenderReferenceDTO::new)
                .forEach(gr -> log.info("GenderReference created: {}", genderReferenceService.createGenderReference(gr)));

    }

}
