package su.vistar.testtask_netcracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import su.vistar.testtask_netcracker.service.TableService;

/**
 *
 * @author dantonov
 */

@Controller
public class HomeController {
    
    
    
    @Autowired
    private TableService tableService;
    
    
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        
        model.addAttribute("tableEntities", tableService.getAll());
        
        return "index";
    }

    
    
}
