package com.example.MotelManagement.service;

import com.example.MotelManagement.entities.Motel;
import com.example.MotelManagement.entities.Payment;
import com.example.MotelManagement.entities.Room;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    Payment save(Payment payment, Room room);
    List<Payment> findAllPayment();

}
