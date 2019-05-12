package hu.giftshop.rest.impl;

import hu.giftshop.controller.AddressController;
import hu.giftshop.entity.Address;
import hu.giftshop.rest.IAddressResource;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
public class AddressResourceImpl implements IAddressResource {

    @EJB
    private AddressController addressController;
    
    @Override
    public List<Address> getAddresses() {
        return addressController.findAll();
    }

    @Override
    public Address getAddress(int id) {
        return addressController.find(id);
    }

    @Override
    public Response createAddress(Address address) {
        addressController.create(address);
        Address affectedAddress = addressController.find(address.getId());
        return Response.ok(affectedAddress, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response updateAddress(Address address) {
        addressController.update(address);
        return Response.ok().build();
    }

    @Override
    public Response deleteAddress(int id) {
        Address address = addressController.find(id);
        addressController.delete(id);
        return Response.ok().build();
    }
    
}
