package com.example.demo.Controller;

import com.example.demo.Model.Address;
import com.example.demo.Model.User;
import com.example.demo.Service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users/{userId}/addresses")
public class AddressController {
     AddressService addressService;

  //  public AddressController(AddressService addressService) {
      //  this.addressService = addressService;
   // }

    @PostMapping
    public ResponseEntity<User> createAddress(@PathVariable Long userId, @RequestBody Address address) {
        User createdAddress = addressService.createAddress(userId, address);
        return ResponseEntity.created(URI.create("/users/" + userId + "/addresses/" + createdAddress.getId()))
                .body(createdAddress);
    }


    @GetMapping
    public List<Address> getAllAddressesByUserId(@PathVariable Long userId) {
        return addressService.getAllAddressesByUserId(userId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        Address address = addressService.getAddressById(id);
        return ResponseEntity.ok(address);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address address) {
        Address updatedAddress = addressService.updateAddress(id, address);
        return ResponseEntity.ok(updatedAddress);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }



}
