package system.dao;

import system.model.Component;

import java.util.List;

public interface ComponentDAO {

    void add(Component component);

    void delete(int id);

    void edit(Component component);

    Component get(int id);

    List<Component> getAllDAO(int page_id, int total);

    List<Component> getTrueDAO(int page_id, int total);

    List<Component> getNotTrueDAO(int page_id, int total);

    int getAssembleCompDAO();

    List<Component> findByNameDAO(String search);
}


