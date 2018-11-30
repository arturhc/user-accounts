package com.tecgurus.useraccounts.app.persistence.model.validation;

import com.tecgurus.useraccounts.common.persistence.model.BaseEntity;

import javax.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "InvalidPassword")
@Table(name = "InvalidPassword", schema = "user_accounts")
public class InvalidPassword extends BaseEntity {

    @Column(unique = true)
    private String password;

}
