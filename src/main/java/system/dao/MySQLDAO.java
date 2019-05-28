package system.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import system.model.Component;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



import javax.annotation.Resource;
import java.util.List;
@Repository
@Transactional
public class MySQLDAO implements ComponentDAO {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    public void add(Component component) {
        Session session = sessionFactory.getCurrentSession();
        session.save(component);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Component component = (Component) session.get(Component.class, id);
        session.delete(component);
    }

    public void edit(Component component) {
        Session session = sessionFactory.getCurrentSession();
        Component editingComponent = (Component) session.get(Component.class, component.getId() );
        editingComponent.setName(component.getName());
        editingComponent.setNecessity(component.isNecessity());
        editingComponent.setAmount(component.getAmount());
        session.save(editingComponent);
    }

    //получение записи по id для редактирования
    public Component get(int id) {
        Session session = sessionFactory.getCurrentSession();
        Component component = (Component) session.get(Component.class, id);
        return component;
    }

    //получение всех записей из таблицы
    public List<Component> getAllDAO(int page_id, int total) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Component com  order by com.name asc");
        query.setFirstResult(page_id);
        query.setMaxResults(total);
        return query.list();
    }

    //получение необходимых комплектующих
    public List<Component> getTrueDAO(int page_id, int total) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Component com where com.necessity = 1 order by com.name asc");
        query.setFirstResult(page_id);
        query.setMaxResults(total);
        return query.list();
    }

    //получение второстепенных комплектующих
    public List<Component> getNotTrueDAO(int page_id, int total) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Component com where com.necessity = 0 order by com.name asc");
        query.setFirstResult(page_id);
        query.setMaxResults(total);
        return query.list();
    }

    //получение возможного количества собранных компьютеров
    public int getAssembleCompDAO(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select min(com.amount) from Component com where com.necessity = 1");
        List<Integer>list = query.list();
        System.out.println(list.size());
        Integer count = list.get(0);
        if(count == null) return 0;
        return count;

    }

    //получение записей по имени
    public List<Component> findByNameDAO(String search) {
        Session session = sessionFactory.getCurrentSession();
        String searchQuery =  "from Component com where com.name like :findWord";
        Query query = session.createQuery(searchQuery);
        query.setParameter("findWord", "%" + search + "%");
        return query.list();
    }
}
