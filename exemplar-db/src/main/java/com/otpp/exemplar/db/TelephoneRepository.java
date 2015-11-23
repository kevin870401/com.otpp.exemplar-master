package com.otpp.exemplar.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TelephoneRepository extends JpaRepository<Telephone, Telephone> {

    @Query("SELECT phone FROM Telephone phone WHERE phone.entityIrn=:irn")
    List<Telephone> findByIrn(@Param("irn") String irn);
}
