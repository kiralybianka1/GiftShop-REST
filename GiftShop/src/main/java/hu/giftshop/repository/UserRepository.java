package hu.giftshop.repository;

import hu.giftshop.entity.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless
public class UserRepository {
    
    @PersistenceContext(unitName = "giftshopPU")
    private EntityManager em;

    public UserRepository() {
        
    }
    
    public User findByUserName(String userName){
        Query query = em.createQuery("SELECT u FROM User u WHERE u.username = :username");
        query.setParameter("username",userName);
        User user = (User)query.getSingleResult();
        
        return user;
    }
    
}
