package com.javainusestore.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javainusestore.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
