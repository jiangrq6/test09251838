package com.unicom.beijing.dao;

import com.unicom.beijing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
