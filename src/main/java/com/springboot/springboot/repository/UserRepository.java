package com.springboot.springboot.repository;

import com.springboot.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u where u.id > :id")
    public List<User> findAllMoreThan(@Param("id") Long id);


    public List<User> findByIdGreaterThan(Long id);

}
