package app.orm.model;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "password")
    private String password;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona ;
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Usuario_rol> usuario_rol;
    public Usuario() {}

    public Usuario(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }	

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }	

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }	

    public void setPassword(String password) {
        this.password = password;
    }
     public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public List<Usuario_rol> getUsuario_rol() {
           return usuario_rol;
    }

    public void setUsuario_rol(List<Usuario_rol> usuario_rol) {
        this.usuario_rol = usuario_rol;
    }
}