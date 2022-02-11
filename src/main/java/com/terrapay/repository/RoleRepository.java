package com.terrapay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.terrapay.entity.Role;
import com.terrapay.entity.User;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	public Optional<Role> findById(Integer id);
}
