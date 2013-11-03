/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
@Table(name = "usuario_rol")
public class Usuario_rol implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "authority")
    private String authority;
  @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "usuario")
    private Usuario usuario ;
  public Usuario_rol() {}

    public Usuario_rol(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }	

    public void setId(Long id) {
        this.id = id;
    }
public String getAuthority() {
        return authority;
    }	

    public void setAuthority(String authority) {
        this.authority = authority;
    } 
}
