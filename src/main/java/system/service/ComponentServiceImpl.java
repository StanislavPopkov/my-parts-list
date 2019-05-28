package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.dao.ComponentDAO;
import system.dao.MySQLDAO;
import system.model.Component;

import java.util.List;

@Service
public class ComponentServiceImpl implements ComponentService {
    @Autowired
    private ComponentDAO mySQLDAO;

    public void add(Component component) {
        mySQLDAO.add(component);
    }

    public void delete(int id) {
        mySQLDAO.delete(id);
    }

    public void edit(Component component) {
        mySQLDAO.edit(component);
    }

    public Component get(int id) {
        return mySQLDAO.get(id);
    }

    public List<Component> getAllService(int page_id, int total) {
        return mySQLDAO.getAllDAO(page_id, total);
    }

    public List<Component> getTrueService(int page_id, int total) {
        return mySQLDAO.getTrueDAO(page_id, total);
    }

    public List<Component> getNotTrueService(int page_id, int total) {
        return mySQLDAO.getNotTrueDAO(page_id, total);
    }

    public int getAssembleCompService(){
        return mySQLDAO.getAssembleCompDAO();
    }

    public List<Component> findByNameService(String search) {
        return mySQLDAO.findByNameDAO(search);
    }
}
