package com.backendV1.backendV1.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backendV1.backendV1.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	
}
