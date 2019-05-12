package hu.giftshop.repository;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class BaseRepository<T extends Serializable> implements IGenericRepository<T> {

     Class<T> entityClass;
    
    @PersistenceContext(unitName = "giftshopPU")
    protected EntityManager em;

    public BaseRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public BaseRepository() {
    }
    
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public T find(int id) {
        return getEntityManager().find(entityClass, id);
    }

    @Override
    public void save(T entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public void update(T entity) {
        getEntityManager().merge(entity);
    }

    @Override
    public void delete(T entity) {
        getEntityManager().remove(entity);
    }

    @Override
    public void refresh(T entity) {
        getEntityManager().refresh(entity);
    }

    public List<T> findAll(){
        Query query = getEntityManager().createNamedQuery(entityClass.getSimpleName() + ".findAll");
        return query.getResultList();
    }
    
}
