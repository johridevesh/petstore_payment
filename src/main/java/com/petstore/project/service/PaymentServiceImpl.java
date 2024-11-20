package com.petstore.project.service;

import com.petstore.project.entity.PaymentEntity;
import com.petstore.project.model.Payment;
import com.petstore.project.model.PaymentResponse;
import com.petstore.project.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<PaymentResponse> listAllPayments() {
        return paymentRepository.findAll().stream()
                .map(this::convertEntityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePaymentById(Integer id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public PaymentResponse getPaymentById(Integer id) {
        return paymentRepository.findById(id)
                .map(this::convertEntityToModel)
                .orElse(null);
    }

    @Override
    public PaymentResponse updatePayment(Integer id, Payment payment) {
        PaymentEntity paymentEntity = convertModelToEntity(payment);
        paymentEntity.setId(id);
        PaymentEntity updatedEntity = paymentRepository.save(paymentEntity);
        return convertEntityToModel(updatedEntity);
    }

    @Override
    public PaymentResponse createPayment(Payment payment) {
        PaymentEntity paymentEntity = convertModelToEntity(payment);
        PaymentEntity savedEntity = paymentRepository.save(paymentEntity);
        return convertEntityToModel(savedEntity);
    }

    private PaymentResponse convertEntityToModel(PaymentEntity entity) {
        return new PaymentResponse()
                .id(entity.getId())
                .orderId(entity.getOrderId())
                .amount(entity.getAmount())
                .paymentDate(entity.getPaymentDate())
                .paymentMethod(entity.getPaymentMethod());
    }

    private PaymentEntity convertModelToEntity(Payment model) {
        PaymentEntity entity = new PaymentEntity();
        entity.setId(model.getId());
        entity.setOrderId(model.getOrderId());
        entity.setAmount(model.getAmount());
        entity.setPaymentDate(model.getPaymentDate());
        entity.setPaymentMethod(model.getPaymentMethod());
        return entity;
    }
}