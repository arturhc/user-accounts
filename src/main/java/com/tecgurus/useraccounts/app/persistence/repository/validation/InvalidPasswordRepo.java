package com.tecgurus.useraccounts.app.persistence.repository.validation;

import com.tecgurus.useraccounts.app.persistence.model.validation.InvalidPassword;
import com.tecgurus.useraccounts.common.persistence.repository.SoftDeleteRepository;

import java.util.Optional;

public interface InvalidPasswordRepo extends SoftDeleteRepository<InvalidPassword, Long> {

    Optional<InvalidPassword> findByPassword(String password);

}
