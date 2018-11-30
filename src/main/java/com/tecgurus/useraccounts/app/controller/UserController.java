package com.tecgurus.useraccounts.app.controller;

import com.tecgurus.useraccounts.app.dto.user.create.UserCreateDTO;
import com.tecgurus.useraccounts.app.service.user.UserService;

import com.tecgurus.useraccounts.common.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.Valid;

import lombok.*;

@RestController
@RequestMapping("/api-user-accounts/users")
public class UserController extends BaseController {

    @Setter(onMethod = @__(@Autowired))
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity create(@RequestBody @Valid UserCreateDTO userInput, BindingResult br) throws Exception {
        throwErrors(br);
        return ResponseEntity.ok(userService.createAccount(userInput));
    }

    @GetMapping("/confirm/{token}")
    public ResponseEntity confirm(@PathVariable("token") @NotEmpty String token) throws Exception {
        return ResponseEntity.ok(userService.confirmAccount(token));
    }

}
