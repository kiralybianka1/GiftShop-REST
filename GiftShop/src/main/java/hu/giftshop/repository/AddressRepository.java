package hu.giftshop.repository;

import hu.giftshop.entity.Address;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class AddressRepository extends BaseRepository<Address> {
    
    public AddressRepository(){
        super(Address.class);
    }

    public Address findByAllDetails(Address address){
        Query query = getEntityManager().createNamedQuery("Address.findByAllDetails");
        query.setParameter("country", address.getCountry());
        query.setParameter("zipCode", address.getZipCode());
        query.setParameter("city", address.getCity());
        query.setParameter("street", address.getStreet());
        query.setParameter("houseNumber", address.getHouseNumber());
        query.setParameter("floor", address.getFloor());
        query.setParameter("door", address.getDoor());
        query.setParameter("doorbell", address.getDoorbell());
        if( query.getResultList().size() == 1){
            Address existingAddress = (Address) query.getResultList().get(0);    
            return existingAddress;
        } else {
            return null;
        }
    }

}
