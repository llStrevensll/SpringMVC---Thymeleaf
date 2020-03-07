package co.com.strevens.HolaMundoThymeleaf;

import co.com.strevens.domain.Persona;
import java.util.ArrayList;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {
    @Value("${index.saludo}")
    private String saludo;
    
    @GetMapping("/")
    public String inicio(Model model){
        var mensaje = "Mensaje con Thymeleaf";
        var persona = new Persona();
        persona.setNombre("Angel");
        persona.setApellido("Rodriguez");
        persona.setEmail("correo@corre.com");
        persona.setTelefono("12345678");
        
        var persona1 = new Persona();
        persona1.setNombre("Steven");
        persona1.setApellido("Rodriguez");
        persona1.setEmail("correo1@corre.com");
        persona1.setTelefono("123456789");
        
        //var personas = new ArrayList();
        //personas.add(persona);
        //personas.add(persona1);
        
        var personas = Arrays.asList(persona, persona1);
        //var personas = new ArrayList();
        log.info("Ejecutando el controlador Spring MVC");
        
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        //model.addAttribute("persona", persona);
        model.addAttribute("personas", personas);
        
        return "index";
    }
}
