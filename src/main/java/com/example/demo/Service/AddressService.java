package com.example.demo.Service;

import com.example.demo.Model.Address;
import com.example.demo.Model.User;

import java.util.List;

public interface AddressService {
    User createAddress(Long userId, Address address);
    List<Address> getAllAddressesByUserId(Long userId);
    Address getAddressById(Long id);
    Address updateAddress(Long id, Address address);
    void deleteAddress(Long id);
}
