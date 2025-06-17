package com.acme.JPA;

import com.acme.ENTITY.Ejogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface jogoRepository  extends JpaRepository<Ejogo, Integer>{
    

}
