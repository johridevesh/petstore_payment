package com.petstore.project.api;

import com.petstore.project.model.Payment;
import com.petstore.project.model.PaymentResponse;
import com.petstore.project.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@Validated
@Tag(name = "payments", description = "the payments API")
@RestController
@RequestMapping("/payments")
public class PaymentsApiController implements PaymentsApi {

    private final PaymentService paymentService;

    @Autowired
    public PaymentsApiController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    @Operation(
        operationId = "paymentsGet",
        summary = "List all payments",
        responses = {
            @ApiResponse(responseCode = "200", description = "A list of payments", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentResponse.class))
            })
        }
    )
    @GetMapping(produces = { "application/json" })
    public ResponseEntity<List<PaymentResponse>> paymentsGet() {
        List<PaymentResponse> payments = paymentService.listAllPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @Override
    @Operation(
        operationId = "paymentsIdDelete",
        summary = "Delete a payment",
        responses = {
            @ApiResponse(responseCode = "204", description = "Payment deleted")
        }
    )
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> paymentsIdDelete(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id) {
        paymentService.deletePaymentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @Operation(
        operationId = "paymentsIdGet",
        summary = "Get a payment by ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Payment details", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentResponse.class))
            })
        }
    )
    @GetMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity<PaymentResponse> paymentsIdGet(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id) {
        PaymentResponse payment = paymentService.getPaymentById(id);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @Override
    @Operation(
        operationId = "paymentsIdPut",
        summary = "Update a payment",
        responses = {
            @ApiResponse(responseCode = "200", description = "Payment updated")
        }
    )
    @PutMapping(value = "/{id}", consumes = { "application/json" })
    public ResponseEntity<PaymentResponse> paymentsIdPut(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id,
        @Parameter(name = "Payment", description = "") @Valid @RequestBody(required = false) Payment payment) {
        PaymentResponse updatedPayment = paymentService.updatePayment(id, payment);
        return new ResponseEntity<>(updatedPayment, HttpStatus.OK);
    }

    @Override
    @Operation(
        operationId = "paymentsPost",
        summary = "Create a new payment",
        responses = {
            @ApiResponse(responseCode = "201", description = "Payment created")
        }
    )
    @PostMapping(consumes = { "application/json" })
    public ResponseEntity<PaymentResponse> paymentsPost(
        @Parameter(name = "Payment", description = "") @Valid @RequestBody(required = false) Payment payment) {
        PaymentResponse createdPayment = paymentService.createPayment(payment);
        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }
}