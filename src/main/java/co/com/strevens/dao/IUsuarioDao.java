package co.com.strevens.dao;

import co.com.strevens.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioDao extends JpaRepository<Usuario, Long>{
    
    Usuario findByUsername(String username); //Recupera objeto de tipo usuario
}
