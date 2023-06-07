package mx.com.gm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author kevin
 */
@Controller //Crear un controlador de MVC
//Utiliza archivos de html 
//Ya no se extienden de HTTPServlet, mas facil configuración

@Slf4j
public class ControladorInicio {
    @Value("${index.saludo}")
    private String saludo;
    
    @GetMapping("/")
    public String inicio(Model model){
        var mensaje = "Mensaje con thymeleaf";
        var persona = new Persona();
        
        persona.setNombre("Kevin");
        persona.setApellido("Lopez");
        persona.setEmail("kevin@gmail.com");
        persona.setTelefono("3787847496");
        
        var persona2 = new Persona();
        
        persona2.setNombre("Karla");
        persona2.setApellido("Gomez");
        persona2.setEmail("kGomez@gmail.com");
        persona2.setTelefono("13229900");
/* 
        List<Persona> personas = new ArrayList();
        personas.add(persona);
        personas.add(persona2);
*/
        var personas = Arrays.asList(persona,persona2);
        
        //Compartir objeto de clase persona a la vista
        //model.addAttribute("persona",persona);
        
        //Compartir una lista de objetos (personas) a la vista
        model.addAttribute("personas", personas);
        
        //Compartir texto desde variables o propierties
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo",saludo);
        
        log.info("Ejecuntando controlador de MVC");
        return "index";
    }
}
