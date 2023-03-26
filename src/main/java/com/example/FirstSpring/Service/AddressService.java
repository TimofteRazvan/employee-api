package com.example.FirstSpring.Service;

import com.example.FirstSpring.Entity.Address;
import com.example.FirstSpring.Repository.AddressRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddress(int id) throws Exception {
        if(!addressRepository.existsById(id)) {
            throw new Exception("getAddress(): Incorrect ID!");
        }
        return addressRepository.findById(id).get();
    }

    public void createAddress(Address address) {
        addressRepository.save(address);
    }

    public void updateAddress(int id, Address address) throws Exception {
        if(!addressRepository.existsById(id)) {
            throw new Exception("updateAddress(): Incorrect ID!");
        }
        Address addressToUpdate = addressRepository.getOne(id);
        addressToUpdate.setLine1(address.getLine1());
        addressToUpdate.setLine2(address.getLine2());
        addressToUpdate.setZipCode(address.getZipCode());
        addressToUpdate.setCity(address.getCity());
        addressToUpdate.setState(address.getState());
        addressToUpdate.setCountry(address.getCountry());
        addressToUpdate.setEmployee(address.getEmployee());
        addressRepository.save(addressToUpdate);
    }

    public void deleteAddress(int id) throws Exception {
        if(!addressRepository.existsById(id)) {
            throw new Exception("deleteAddress(): Incorrect ID!");
        }
        addressRepository.deleteById(id);
    }
}
