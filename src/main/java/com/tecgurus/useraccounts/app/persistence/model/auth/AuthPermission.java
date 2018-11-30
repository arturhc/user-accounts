package com.tecgurus.useraccounts.app.persistence.model.auth;

import com.tecgurus.useraccounts.common.persistence.model.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "AuthPermission")
@Table(name = "AuthPermission", schema = "user_accounts")
public class AuthPermission extends BaseEntity {

    @Column(nullable = false)
    private String name;
    
    @ManyToMany(mappedBy = "permissions")
    private List<Role> roles = new ArrayList<>();

    public AuthPermission(String name) { this.name = name; }

}
