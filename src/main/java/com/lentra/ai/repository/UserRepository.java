package com.lentra.ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lentra.ai.entities.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
}