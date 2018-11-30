package com.tecgurus.useraccounts.app.persistence.model;

import com.tecgurus.useraccounts.common.persistence.model.BaseEntity;

import javax.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "GenderReference")
@Table(name = "GenderReference", schema = "user_accounts")
public class GenderReference extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String description;

}
