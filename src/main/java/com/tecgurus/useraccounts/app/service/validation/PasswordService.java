package com.tecgurus.useraccounts.app.service.validation;

import com.tecgurus.useraccounts.app.dto.validation.InvalidPasswordDTO;
import com.tecgurus.useraccounts.app.dto.validation.InvalidPasswordOutDTO;
import com.tecgurus.useraccounts.app.persistence.model.validation.InvalidPassword;
import com.tecgurus.useraccounts.app.persistence.repository.validation.InvalidPasswordRepo;
import com.tecgurus.useraccounts.common.config.exception.model.ValidationException;
import com.tecgurus.useraccounts.common.service.BaseService;

import com.tecgurus.useraccounts.common.util.EventMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PasswordService extends BaseService<InvalidPasswordRepo, InvalidPassword> {

    public InvalidPasswordOutDTO findInvalidPasswordByPassword(String password) throws ValidationException {

        Optional<InvalidPassword> invalidPassword = repository.findByPassword(password);

        return convertUtil.convert(invalidPassword.orElseThrow(() ->
                new ValidationException(EventMessage.NON_EXISTENT_INVALID_PASSWORD, password)), InvalidPasswordOutDTO.class);
    }

    public List<InvalidPasswordOutDTO> findAllInvalidPasswords() {
        return findAll(InvalidPasswordOutDTO.class);
    }

    public InvalidPasswordOutDTO createInvalidPassword(InvalidPasswordDTO invalidPassword) {

        String password = invalidPassword.getPassword();

        try {

            findInvalidPasswordByPassword(password);

        } catch (ValidationException ex) {

            try {
                return save(invalidPassword, InvalidPasswordOutDTO.class);
            } catch (Exception ignored) {
                log.error("Error creating invalid password with value: {}", password);
            }

        }

        return null;
    }

}
