package system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import system.model.Component;
import system.service.ComponentService;
import system.service.ComponentServiceImpl;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

//путь для запуска http://localhost:8080/my-parts-list/store/main/1?choice=allParts
@Controller
@RequestMapping("/store")
public class ComponentController {

    @Resource(name= "componentServiceImpl")
    private ComponentService componentServiceImpl;
    //главный метод вывода таблицы, выводит данные в зависимости от от атбибута choice.
    @RequestMapping(value = "/main/{page_id}", method = RequestMethod.GET)
    public String getComponents(@PathVariable int page_id, String choice, Model model) {
        int total = 10;
        if(page_id == 1) {
            // do nothing!
        } else page_id= (page_id-1)*total+1;

        List<Component> components = null;
        int count = getAssembleComp();
        String switchPaginationField = null;
        if(choice.equals("trueParts")) {
            components = componentServiceImpl.getTrueService(page_id, total);
            switchPaginationField = "allTrue";
        }
        else if(choice.equals("notTrueParts")){
            components = componentServiceImpl.getNotTrueService(page_id, total);
            count = -1;
            switchPaginationField = "allNotTrue";
        }
        else{
            components = componentServiceImpl.getAllService(page_id, total);
            switchPaginationField = "all";
        }

        model.addAttribute("components", components);
        model.addAttribute("count", count);
        model.addAttribute("switchPaginationField", switchPaginationField);
        return "store_page";
    }
    //вывод возможного количества собранных компьютеров
    public int getAssembleComp(){
        return componentServiceImpl.getAssembleCompService();
    }

    //поиск по имени
    @RequestMapping(value = "/main/search", method = RequestMethod.GET)
    public String findComponentByName(@RequestParam String search, Model model){
        List<Component> components = componentServiceImpl.findByNameService(search);
        model.addAttribute("components", components);
        return "search_page";
    }

    //добавление записей в таблицу, вызывает страницу с формой для заполнения
    @RequestMapping(value = "/main/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
        model.addAttribute("componentAttribute", new Component());
        return "add_form";
    }

    //добавление записей в таблицу, принимает данные со страницы с формой
    @RequestMapping(value = "/main/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("componentAttribute") Component component, Model model) {
        componentServiceImpl.add(component);
        String main_page = getComponents(1, "allParts", model);
        return main_page;
    }

    //удаление
    @RequestMapping(value = "/main/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value="id", required=true) Integer id, Model model) {
        componentServiceImpl.delete(id);
        String main_page = getComponents(1, "allParts", model);
        return main_page;
    }

    //редактирование записей, запрашивает данные в базе и передает их вместе со страницей
    @RequestMapping(value = "/main/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value="id", required=true) Integer id, Model model) {
        model.addAttribute("componentAttribute", componentServiceImpl.get(id));
        return "edit_form";
    }

    //принимает данные со страницы редактирования и сохраняет их
    @RequestMapping(value = "/main/edit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("componentAttribute") Component component,
                           @RequestParam(value="id", required=true) Integer id,
                           Model model) {
        componentServiceImpl.edit(component);
        String main_page = getComponents(1, "allParts", model);
        return main_page;
    }
}
