package com.tecgurus.useraccounts.app.persistence.repository;

import com.tecgurus.useraccounts.app.persistence.model.auth.User;
import com.tecgurus.useraccounts.common.persistence.repository.SoftDeleteRepository;

import java.util.Optional;

public interface UserRepo extends SoftDeleteRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByConfirmationToken(String confirmationToken);

}
