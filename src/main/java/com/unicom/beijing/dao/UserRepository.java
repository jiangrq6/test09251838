package com.unicom.beijing.dao;

import com.unicom.beijing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query(nativeQuery = true,value = "SELECT * from `unicom_user` where login = ?1")
    User getAllByLogin(String login);
}
