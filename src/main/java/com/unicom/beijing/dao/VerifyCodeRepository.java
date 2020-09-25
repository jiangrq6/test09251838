package com.unicom.beijing.dao;

import com.unicom.beijing.entity.VerifyCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VerifyCodeRepository extends JpaRepository<VerifyCode,Long> {

    @Query(nativeQuery = true,value = "SELECT * from verify_code where phone = ?1 and state = 'pending'")
    VerifyCode getAllByLogin(String login);
}
