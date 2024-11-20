package com.petstore.project.service;

import com.petstore.project.model.Payment;
import com.petstore.project.model.PaymentResponse;
import java.util.List;

public interface PaymentService {

    /**
     * List all payments
     *
     * @return A list of payments
     */
    List<PaymentResponse> listAllPayments();

    /**
     * Delete a payment by ID
     *
     * @param id the ID of the payment to delete
     */
    void deletePaymentById(Integer id);

    /**
     * Get a payment by ID
     *
     * @param id the ID of the payment to retrieve
     * @return Payment details
     */
    PaymentResponse getPaymentById(Integer id);

    /**
     * Update a payment
     *
     * @param id the ID of the payment to update
     * @param payment the payment details to update
     * @return Updated payment details
     */
    PaymentResponse updatePayment(Integer id, Payment payment);

    /**
     * Create a new payment
     *
     * @param payment the payment details to create
     * @return Created payment details
     */
    PaymentResponse createPayment(Payment payment);
}
