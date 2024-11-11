package com.pablomonteserin.login.persistence.repository;

import com.pablomonteserin.login.persistence.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    @Query("SELECT m FROM Message m WHERE m.remitente.id = :id")
    List<Message> findMessagesByRemitenteId(@Param("id") Integer remitenteId);


}
