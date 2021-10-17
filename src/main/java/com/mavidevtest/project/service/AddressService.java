package com.mavidevtest.project.service;

import com.mavidevtest.project.model.Address;
import com.mavidevtest.project.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepo;

    public List<Address> listAll(){
        return addressRepo.findAll();
    }

    public void save(Address address)
    {
        addressRepo.save(address);
    }

    public void addAddress(Address address)
    {
        addressRepo.save(address);
    }
    public Address get(long id) {
        return addressRepo.getOne(id);
    }

    public void delete(long id) {
        addressRepo.deleteById(id);
    }

    public List<Address> findByKeyword(String keyword)
    {
        return addressRepo.findByKeyword(keyword);
    }
}
