package co.com.strevens.dao;

import co.com.strevens.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IPersonaDao extends JpaRepository<Persona, Long>{
    
}
