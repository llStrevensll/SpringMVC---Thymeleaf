package co.com.strevens.web;


import co.com.strevens.domain.Persona;
import co.com.strevens.servicio.IPersonaService;
import java.util.ArrayList;
import java.util.Arrays;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {
    /*
    @Value("${index.saludo}")
    private String saludo;*/
    
    
    @Autowired //Inyectar
    private IPersonaService personaService;
    
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){
        var personas = personaService.listarPersona();
        
        log.info("Ejecutando el controlador Spring MVC");
        log.info("usuario que hizo login:" + user);
        //model.addAttribute("saludo", saludo);
        model.addAttribute("personas", personas);
        
        return "index";
    }
    
    
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        personaService.guardar(persona);
        return "redirect:/";//inicio
    }
    
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
        
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    
    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
}
