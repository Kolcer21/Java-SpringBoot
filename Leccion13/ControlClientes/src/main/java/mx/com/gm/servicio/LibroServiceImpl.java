package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.ILibroDao;
import mx.com.gm.domain.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class LibroServiceImpl implements LibroService{

    //Concepto de transacciones: Se usan varias operaciones sobre tablas de bd
    @Autowired
    private ILibroDao libroDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Libro> listarLibros() {
        return (List<Libro>) libroDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Libro libro) {
        libroDao.save(libro);
    }

    @Override
    @Transactional
    public void eliminar(Libro libro) {
        libroDao.delete(libro);

    }

    @Override
    @Transactional(readOnly = true)
    public Libro encontrarLibro(Libro libro) {
        return libroDao.findById(libro.getIdLibro()).orElse(null);
    }
    
}
