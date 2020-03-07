package co.com.strevens.HolaMundoThymeleaf;

import co.com.strevens.domain.Persona;
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
        log.info("Ejecutando el controlador Spring MVC");
        
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        model.addAttribute("persona", persona);
        
        return "index";
    }
}
