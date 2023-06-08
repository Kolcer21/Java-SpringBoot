package mx.com.gm.web;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.dao.ILibroDao;
import mx.com.gm.servicio.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    private LibroService libroService;
    
    @GetMapping("/")
    public String inicio(Model model){
        
        var libros = libroService.listarLibros();
        
        //Compartir una lista de objetos (personas) a la vista
        model.addAttribute("libros", libros);   
        log.info("Ejecuntando controlador de MVC");
        return "index";
    }
}
