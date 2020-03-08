package co.com.strevens.dao;

import co.com.strevens.domain.Persona;
import org.springframework.data.repository.CrudRepository;


public interface IPersonaDao extends CrudRepository<Persona, Long>{
    
}
