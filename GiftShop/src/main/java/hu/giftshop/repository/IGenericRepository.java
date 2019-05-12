package hu.giftshop.repository;

public interface IGenericRepository<T> {
    	
    public T find(int id);

    public void save(T entity);

    public void update(T entity);

    public void delete(T entity);

    public void refresh(T entity);
    
}
