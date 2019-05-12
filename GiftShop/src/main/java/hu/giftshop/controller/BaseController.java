package hu.giftshop.controller;

import hu.giftshop.repository.BaseRepository;
import java.io.Serializable;
import java.util.List;

public abstract class BaseController<T extends Serializable> {
    
    protected BaseController(){    
    }
    
    protected abstract BaseRepository<T> getRepository(); 
    
    public T find(int id) {
        return getRepository().find(id);
    }

    public void save(T entity) {
        getRepository().save(entity);
    }

    public void update(T entity) {
        getRepository().update(entity);
    }

    public void delete(int id) {
        getRepository().delete(getRepository().find(id));
    }

    public void refresh(T entity) {
        getRepository().refresh(entity);
    }

    public List<T> findAll() {
        return getRepository().findAll();
    }
}
