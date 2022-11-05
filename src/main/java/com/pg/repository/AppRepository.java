package com.pg.repository;

import com.pg.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepository extends JpaRepository<User,Long> {
    public User findByName(String username);
}
