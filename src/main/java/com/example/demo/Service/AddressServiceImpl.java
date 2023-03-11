package com.example.demo.Service;

import com.example.demo.Model.Address;
import com.example.demo.Model.User;
import com.example.demo.Repository.AddressRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class AddressServiceImpl implements AddressService {

     UserRepository userRepository;
     AddressRepository addressRepository;
@Autowired
    public AddressServiceImpl(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public User createAddress(Long userId, Address address) {
        User user = userRepository.findById(userId)
                .orElseThrow();
        return user;
    }

    @Override
    public List<Address> getAllAddressesByUserId(Long userId) {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElseThrow();
    }

    @Override
    public Address updateAddress(Long id, Address address) {
        return null;
    }

    @Override
    public void deleteAddress(Long id) {

    }
}

