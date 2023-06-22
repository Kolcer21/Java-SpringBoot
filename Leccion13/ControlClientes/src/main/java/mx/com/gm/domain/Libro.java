package mx.com.gm.domain;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="libro")
public class Libro implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibro;

    @NotEmpty
    private String nombre;
    @NotEmpty
    private String editorial;
    @NotEmpty
    private String extension;
    @NotEmpty
    private String autor;

    
}
