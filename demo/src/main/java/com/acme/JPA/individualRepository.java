package com.acme.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import com.acme.ENTITY.Eindividual;

public interface individualRepository extends JpaRepository <Eindividual, String> {

}
