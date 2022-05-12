package com.alnicode.samplecrud.repository;

import com.alnicode.samplecrud.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    
}
