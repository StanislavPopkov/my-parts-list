package system.service;

import system.model.Component;

import java.util.List;

public interface ComponentService {
    void add(Component component);

    void delete(int id);

    void edit(Component component);

    Component get(int id);

    List<Component> getAllService(int page_id, int total);

    List<Component> getTrueService(int page_id, int total);

    List<Component> getNotTrueService(int page_id, int total);

    int getAssembleCompService();

    List<Component> findByNameService(String search);
}
