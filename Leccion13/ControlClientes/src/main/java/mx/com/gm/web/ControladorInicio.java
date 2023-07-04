package mx.com.gm.web;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Libro;
import mx.com.gm.servicio.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String inicio(Model model, @AuthenticationPrincipal User user){
        
        var libros = libroService.listarLibros();
        
        //Compartir una lista de objetos (personas) a la vista
        model.addAttribute("libros", libros);   
        log.info("Ejecuntando controlador de MVC");
        log.info("Usuario que hizo login "+user);

        model.addAttribute("totalLibros", libros.size());
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Libro libro){
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Libro libro, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        libroService.guardar(libro);
        return "redirect:/";
    }

    @GetMapping("/editar/{idLibro}")
        public String editar(Libro libro, Model model){
            libro = libroService.encontrarLibro(libro);
            model.addAttribute("libro", libro);
            return "modificar";
        }

    @GetMapping("/eliminar")
    public String eliminar(Libro libro){
        libroService.eliminar(libro);
        return "redirect:/";
    }
    
}
