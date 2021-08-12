package com.gotarrays.userservice.repo;

import com.gotarrays.userservice.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
  Role findByName(String name);
}
