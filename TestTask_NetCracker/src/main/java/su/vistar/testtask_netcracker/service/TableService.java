package su.vistar.testtask_netcracker.service;

import su.vistar.testtask_netcracker.entity.TableEntity;

/**
 *
 * @author dantonov
 */
public interface TableService {
    
    
    Iterable<TableEntity> getAll();
    
    TableEntity getById(Integer id);
    
    TableEntity save(TableEntity entity);
    
    void delete(TableEntity entity);

    
}
