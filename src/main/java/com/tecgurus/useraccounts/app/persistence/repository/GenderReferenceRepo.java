package com.tecgurus.useraccounts.app.persistence.repository;

import com.tecgurus.useraccounts.app.persistence.model.GenderReference;
import com.tecgurus.useraccounts.common.persistence.repository.SoftDeleteRepository;

import java.util.Optional;

public interface GenderReferenceRepo extends SoftDeleteRepository<GenderReference, Long> {

    Optional<GenderReference> findByDescription(String description);

}
