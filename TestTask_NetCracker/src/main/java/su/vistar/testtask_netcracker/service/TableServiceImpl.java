package su.vistar.testtask_netcracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import su.vistar.testtask_netcracker.entity.TableEntity;
import su.vistar.testtask_netcracker.repository.TableRepository;

/**
 *
 * @author dantonov
 */

@Service
public class TableServiceImpl implements TableService {

    
    
    @Autowired
    protected TableRepository tableRepository;
    
    
    
    
    @Override
    public Iterable<TableEntity> getAll() {
        return tableRepository.findAll();
    }
    
    
    @Override
    public TableEntity getById(Integer id) {
        return tableRepository.findOne(id);
    }

    
    @Override
    @Transactional
    public TableEntity save(TableEntity entity) {
        return tableRepository.save(entity);
    }

    
    @Override
    @Transactional
    public void delete(TableEntity entity) {
        tableRepository.delete(entity);
    }

    
    
}
