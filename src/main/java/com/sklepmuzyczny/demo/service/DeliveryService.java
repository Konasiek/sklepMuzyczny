package com.sklepmuzyczny.demo.service;

import com.sklepmuzyczny.demo.model.Delivery;
import com.sklepmuzyczny.demo.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {

    private DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public void addNewDelivery(Delivery delivery) {
        deliveryRepository.save(delivery);
    }

    public List<Delivery> getDeliveries() {
        List<Delivery> list = (List) deliveryRepository.findAll();
        return list;
    }
    public Delivery getDeliveryById(Long id) {
        Delivery delivery = (Delivery) deliveryRepository.findById(id).get();
        return delivery;
    }

    public void deleteById(Long id) {
        deliveryRepository.deleteById(id);
    }
}
