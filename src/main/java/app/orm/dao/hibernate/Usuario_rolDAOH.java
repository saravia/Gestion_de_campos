
package app.orm.dao.hibernate;
import app.orm.dao.BaseHibernateDAO;
import app.orm.dao.Usuario_rolDAO;
import app.orm.model.Usuario_rol;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository("usuario_rolDAO")
public class Usuario_rolDAOH extends BaseHibernateDAO implements Usuario_rolDAO {
   public List<Usuario_rol> list() {
        Criteria criteria = this.getSession().createCriteria(Usuario_rol.class);
        return criteria.list();

    }

    public Usuario_rol get(Usuario_rol t) {
        Criteria criteria = this.getSession().createCriteria(Usuario_rol.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return (Usuario_rol) criteria.uniqueResult();
    }   
    
     @Transactional
    public void save(Usuario_rol t) {
        this.getSession().save(t);
    }
    
    @Transactional
    public void update(Usuario_rol t) {
        this.getSession().merge(t);
    }

    @Transactional
    public void delete(Usuario_rol t) {
        this.getSession().delete(t);
    } 
}
