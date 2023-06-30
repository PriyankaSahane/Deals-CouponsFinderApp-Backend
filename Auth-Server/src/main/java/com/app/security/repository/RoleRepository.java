package com.app.security.repository;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.security.models.ERole;
import com.app.security.models.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}
