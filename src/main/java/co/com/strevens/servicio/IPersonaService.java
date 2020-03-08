package co.com.strevens.servicio;

import co.com.strevens.domain.Persona;
import java.util.List;

public interface IPersonaService {
    
    public List<Persona> listarPersona();
    public void guardar(Persona persona);
    public void eliminar(Persona persona);
    public Persona encontrarPersona(Persona persona);
}
