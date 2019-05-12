package hu.giftshop.controller;

import hu.giftshop.entity.Address;
import hu.giftshop.repository.AddressRepository;
import hu.giftshop.repository.BaseRepository;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AddressController extends BaseController<Address>{

    @EJB
    private AddressRepository addressRepository;

    public AddressController() {
        super();
    }
    
    @Override
    protected BaseRepository<Address> getRepository() {
        return addressRepository;
    }
    
    public void create(Address address) {
        addressRepository.save(address);
    }
    
    @Override
    public void update(Address address){
        addressRepository.update(address);
    }
    
    @Override
    public void delete(int id){
        getRepository().delete(getRepository().find(id));
    }
    
    public Address getAddressByAllDetails(Address address){
        return addressRepository.findByAllDetails(address);
    }
    
}
