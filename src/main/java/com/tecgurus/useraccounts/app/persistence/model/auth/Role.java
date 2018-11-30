package com.tecgurus.useraccounts.app.persistence.model.auth;

import com.tecgurus.useraccounts.common.persistence.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "Role")
@Table(name = "Role", schema = "user_accounts")
public class Role extends BaseEntity {
    
    @Column(nullable = false)
    private String name;
    
    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "role_permission",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "permission_id", referencedColumnName = "id"))
    private List<AuthPermission> permissions = new ArrayList<>();

    public Role(String name) { this.name = name; }

}