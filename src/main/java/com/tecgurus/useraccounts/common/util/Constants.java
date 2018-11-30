package com.tecgurus.useraccounts.common.util;

import java.util.*;

public class Constants {

    // Swagger
    public static final String AUTHORIZATION = "Authorization";

    // Regex
    public static final String BIRTHDAY_PATTERN = "dd/MM/yyyy";
    public static final String ACTIVATION_ACCOUNT_URL_PROPERTY = "user-accounts.account.register.context";

    // List of examples of invalid passwords
    public static final List<String> INVALID_PASSWORDS = new ArrayList<>(Arrays.asList(
            "password", "pass123", "some_pass_123", "hello123", "password_123"
    ));

    // List of default gender references
    public static final List<String> GENDER_REFERENCES = new ArrayList<>(Arrays.asList(
            "Masculino", "Femenino"
    ));

}
