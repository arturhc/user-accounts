package com.tecgurus.useraccounts.app.dto.validation;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvalidPasswordOutDTO {

    private String password;

}
