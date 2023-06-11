package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Libro;

public interface LibroService {
    
    public List<Libro> listarLibros();
    
    public void guardar (Libro libro);
    
    public void eliminar(Libro libro);

    public Libro encontrarLibro(Libro libro);
    
}
