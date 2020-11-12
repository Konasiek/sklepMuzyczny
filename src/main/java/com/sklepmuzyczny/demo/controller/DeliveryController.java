package com.sklepmuzyczny.demo.controller;

import com.sklepmuzyczny.demo.DTO.DeliveryDTO;
import com.sklepmuzyczny.demo.model.Delivery;
import com.sklepmuzyczny.demo.service.DeliveryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/delivery")
public class DeliveryController {

    DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Delivery> getAllDeliveries() {
        List<Delivery> list = deliveryService.getDeliveries();
        return list;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Delivery getDeliveryById(@PathVariable("id") Long id) {
        Delivery delivery = deliveryService.getDeliveryById(id);
        return delivery;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteDelivery(@PathVariable("id") long id) {
        deliveryService.deleteById(id);
    }

    @PostMapping("/newCategory")
    public Delivery addDelivery(@RequestBody DeliveryDTO deliveryDTO) {

        Delivery delivery = new Delivery();
        delivery.setCart(deliveryDTO.getCart());
        delivery.setCity(deliveryDTO.getCity());
        delivery.setStreet(deliveryDTO.getStreet());
        delivery.setUser(deliveryDTO.getUser());

        deliveryService.addNewDelivery(delivery);
        return delivery;
    }


}
