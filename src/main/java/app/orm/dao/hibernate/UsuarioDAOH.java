

package app.orm.dao.hibernate;
import app.orm.dao.BaseHibernateDAO;
import app.orm.dao.UsuarioDAO;
import app.orm.model.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository("usuarioDAO")
public class UsuarioDAOH extends BaseHibernateDAO implements UsuarioDAO  {
    public List<Usuario> list() {
        Criteria criteria = this.getSession().createCriteria(Usuario.class);
        return criteria.list();

    }

    public Usuario get(Usuario t) {
        Criteria criteria = this.getSession().createCriteria(Usuario.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return (Usuario) criteria.uniqueResult();
    }   
    
     @Transactional
    public void save(Usuario t) {
        this.getSession().save(t);
    }
    
    @Transactional
    public void update(Usuario t) {
        this.getSession().merge(t);
    }

    @Transactional
    public void delete(Usuario t) {
        this.getSession().delete(t);
    }
}
