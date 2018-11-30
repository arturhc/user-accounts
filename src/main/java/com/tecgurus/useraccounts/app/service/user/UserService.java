package com.tecgurus.useraccounts.app.service.user;

import com.tecgurus.useraccounts.app.dto.user.UserDTO;
import com.tecgurus.useraccounts.app.dto.user.create.*;
import com.tecgurus.useraccounts.app.dto.user.create.UserCreateDTO;
import com.tecgurus.useraccounts.app.dto.user.create.UserCreatedDTO;
import com.tecgurus.useraccounts.app.persistence.repository.UserRepo;
import com.tecgurus.useraccounts.app.persistence.model.auth.User;

import com.tecgurus.useraccounts.common.config.exception.model.ValidationException;
import com.tecgurus.useraccounts.common.service.BaseService;

import com.tecgurus.useraccounts.common.util.EventMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.*;

@Service
public class UserService extends BaseService<UserRepo, User> {

    // User service use multiple services that wrap all methods about users.
    @Setter(onMethod = @__(@Autowired))
    private UserAccountService userAccountService;

    public UserDTO findUserById(Long id) throws ValidationException {
        try {
            return findById(id, UserDTO.class);
        } catch (Exception ex) {
            throw new ValidationException(EventMessage.INVALID_USER, id);
        }
    }

    public UserDTO findUser(String email) throws ValidationException {
        return convertUtil.convert(repository.findByEmail(email).orElseThrow(() ->
                new ValidationException(EventMessage.NON_EXISTENT_USER, email)), UserDTO.class);
    }

    public UserCreatedDTO createAccount(UserCreateDTO userCreate) throws Exception {

        // Call a method of user account service
        return userAccountService.createAccount(userCreate);
    }

    public EventMessage confirmAccount(String confirmationToken) throws Exception {
        return userAccountService.confirmAccount(confirmationToken);
    }

}
