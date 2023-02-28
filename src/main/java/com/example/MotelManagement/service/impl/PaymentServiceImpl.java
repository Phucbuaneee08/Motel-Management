package com.example.MotelManagement.service.impl;

import com.example.MotelManagement.entities.Payment;
import com.example.MotelManagement.entities.Room;
import com.example.MotelManagement.repository.PaymentRepository;
import com.example.MotelManagement.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    public PaymentServiceImpl(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }
    @Override
    public Payment save(Payment payment, Room room) {
        payment.setRoom(room);
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> findAllPayment() {
        return paymentRepository.findAll();
    }
}
