

package app.orm.dao.hibernate;
import app.orm.dao.BaseHibernateDAO;
import app.orm.dao.SocioDAO;
import app.orm.model.Socio;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository("socioDAO")
public class SocioDAOH extends BaseHibernateDAO implements SocioDAO{
 public List<Socio> list() {
        Criteria criteria = this.getSession().createCriteria(Socio.class);
        return criteria.list();

    }

    public Socio get(Socio t) {
        Criteria criteria = this.getSession().createCriteria(Socio.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return (Socio) criteria.uniqueResult();
    }    

     @Transactional
    public void save(Socio t) {
        this.getSession().save(t);
    }
    
    @Transactional
    public void update(Socio t) {
        this.getSession().merge(t);
    }

    @Transactional
    public void delete(Socio t) {
        this.getSession().delete(t);
    }
}
