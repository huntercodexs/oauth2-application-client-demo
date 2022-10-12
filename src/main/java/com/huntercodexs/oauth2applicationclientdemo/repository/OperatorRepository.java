package com.huntercodexs.oauth2applicationclientdemo.repository;

import com.huntercodexs.oauth2applicationclientdemo.model.OperatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepository extends JpaRepository<OperatorEntity, Long> {
    OperatorEntity findByAccessCode(String basic);

    @Query(value = "SELECT * FROM oauth2_application_client_operator WHERE accessCode = ?1 AND token = ?2 AND status = 0", nativeQuery = true)
    OperatorEntity findByAccessCodeAndToken(String basic, String token);
}
