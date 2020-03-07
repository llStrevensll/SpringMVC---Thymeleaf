package co.com.strevens.domain;

import lombok.Data;

//Notacion de lombok generar lo metodos get y set, hash code, tostring (mirar ventana navigator)
//lombok genera el estandar de los java beans
@Data
public class Persona {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    
}
