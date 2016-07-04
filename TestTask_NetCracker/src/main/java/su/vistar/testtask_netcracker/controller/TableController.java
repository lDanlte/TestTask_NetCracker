package su.vistar.testtask_netcracker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import su.vistar.testtask_netcracker.dto.TableDto;
import su.vistar.testtask_netcracker.entity.TableEntity;
import su.vistar.testtask_netcracker.exception.NotFoundException;
import su.vistar.testtask_netcracker.service.TableService;

/**
 *
 * @author dantonov
 */

@Controller
@RequestMapping(value = "/table")
public class TableController {
    
    
    
    @Autowired
    private TableService tableService;
    
    
    
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<TableDto> getAll() {
        
        Iterable<TableEntity> entities = tableService.getAll();
        
        List<TableDto> result = new ArrayList<>();
        
        for (TableEntity entity : entities) {
            result.add(toTableDto(entity));
        }
        
        return result;
        
    }
    
    
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TableDto save(@RequestBody TableDto dto) {
        
        TableEntity entity = toTableEntity(dto);
        
        entity = tableService.save(entity);
        
        return toTableDto(entity);
    }
    
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TableDto getById(@PathVariable("id") Integer id) {
        
        TableEntity entity = tableService.getById(id);
        
        if (entity == null) {
            throw new NotFoundException("Ресурс по данному id не найден.");
        }
        
        return toTableDto(entity);
    }
    
    
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TableDto update(@PathVariable("id") Integer id, @RequestBody TableDto dto) {
        
        TableEntity entity = tableService.getById(id);
        
        if (entity == null) {
            throw new NotFoundException("Ресурс по данному id не найден.");
        }
        
        entity.setName(dto.getName());
        entity.setDesc(dto.getDesc());
        
        entity = tableService.save(entity);
        
        return toTableDto(entity);
    }
    
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) {
        
        TableEntity entity = tableService.getById(id);
        
        if (entity == null) {
            throw new NotFoundException("Ресурс по данному id не найден.");
        }
        
        tableService.delete(entity);
    }
    
    
    
    
    private TableDto toTableDto(TableEntity entity) {
        return new TableDto(entity.getId(), entity.getName(), entity.getDesc());
    }
    
    private TableEntity toTableEntity(TableDto dto) {
        return new TableEntity(dto.getId(), dto.getName(), dto.getDesc());
    }

}
