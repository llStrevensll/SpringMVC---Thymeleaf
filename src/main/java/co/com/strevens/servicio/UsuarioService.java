package co.com.strevens.servicio;

import co.com.strevens.dao.IUsuarioDao;
import co.com.strevens.domain.Rol;
import co.com.strevens.domain.Usuario;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Slf4j
public class UsuarioService implements UserDetailsService{
    
    @Autowired
    private IUsuarioDao usuarioDao;
    
    //Obtener usuario filtrado por username
    @Override
    @Transactional(readOnly=true) //Debe ser transaccional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Usuario usuario = usuarioDao.findByUsername(username);
        
        if(usuario == null){
            throw new UsernameNotFoundException(username);
        }
        
        //Asignar al arreglo los roles
        var roles = new ArrayList<GrantedAuthority>();
        for(Rol rol: usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getNombre())); //SimpleGrantedAuthority implementa GrantedAuthority
        }
        
        //User es un objeto de spring - implementa UserDetails
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
    
}
