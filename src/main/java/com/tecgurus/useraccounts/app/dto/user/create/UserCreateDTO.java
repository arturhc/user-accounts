package com.tecgurus.useraccounts.app.dto.user.create;

import com.tecgurus.useraccounts.app.config.validator.password.match.PasswordMatch;
import com.tecgurus.useraccounts.app.config.validator.password.policy.ValidPassword;
import com.tecgurus.useraccounts.app.dto.gender_reference.GenderReferenceDTO;
import com.tecgurus.useraccounts.app.dto.user.UserDTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import lombok.Data;

@Data
@PasswordMatch
public class UserCreateDTO extends UserDTO {

    @NotEmpty(message = "{user.create.empty.password}")
    @ValidPassword
    private String password;

    @NotEmpty(message = "{user.create.empty.confirm-password}")
    @ValidPassword
    private String confirmPassword;

    private String confirmationToken;
    private boolean enabled;

    private String phone;
    private String phoneRegion;

    private String birthdaySt;
    private LocalDate birthday;

    @NotNull(message = "{user.create.invalid.gender-reference}")
    private Long genderReferenceId;

    private GenderReferenceDTO genderReference;

    public boolean checkPasswords() {
        return this.password.equals(confirmPassword);
    }

}
