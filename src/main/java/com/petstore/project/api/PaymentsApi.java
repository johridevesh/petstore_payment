/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.10.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.petstore.project.api;

import com.petstore.project.model.Payment;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-20T08:56:51.518318Z[Etc/UTC]", comments = "Generator version: 7.10.0")
@Validated
@Tag(name = "payments", description = "the payments API")
public interface PaymentsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /payments : List all payments
     *
     * @return A list of payments (status code 200)
     */
    @Operation(
        operationId = "paymentsGet",
        summary = "List all payments",
        responses = {
            @ApiResponse(responseCode = "200", description = "A list of payments", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Payment.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/payments",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<Payment>> paymentsGet(
        
    ) throws Exception {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"amount\" : 1.4658129805029452, \"id\" : 0, \"order_id\" : 6, \"payment_date\" : \"2000-01-23T04:56:07.000+00:00\", \"payment_method\" : \"payment_method\" }, { \"amount\" : 1.4658129805029452, \"id\" : 0, \"order_id\" : 6, \"payment_date\" : \"2000-01-23T04:56:07.000+00:00\", \"payment_method\" : \"payment_method\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /payments/{id} : Delete a payment
     *
     * @param id  (required)
     * @return Payment deleted (status code 204)
     */
    @Operation(
        operationId = "paymentsIdDelete",
        summary = "Delete a payment",
        responses = {
            @ApiResponse(responseCode = "204", description = "Payment deleted")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/payments/{id}"
    )
    
    default ResponseEntity<Void> paymentsIdDelete(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) throws Exception {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /payments/{id} : Get a payment by ID
     *
     * @param id  (required)
     * @return Payment details (status code 200)
     */
    @Operation(
        operationId = "paymentsIdGet",
        summary = "Get a payment by ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Payment details", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Payment.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/payments/{id}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<Payment> paymentsIdGet(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) throws Exception {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"amount\" : 1.4658129805029452, \"id\" : 0, \"order_id\" : 6, \"payment_date\" : \"2000-01-23T04:56:07.000+00:00\", \"payment_method\" : \"payment_method\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /payments/{id} : Update a payment
     *
     * @param id  (required)
     * @param payment  (optional)
     * @return Payment updated (status code 200)
     */
    @Operation(
        operationId = "paymentsIdPut",
        summary = "Update a payment",
        responses = {
            @ApiResponse(responseCode = "200", description = "Payment updated")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/payments/{id}",
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Void> paymentsIdPut(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id,
        @Parameter(name = "Payment", description = "") @Valid @RequestBody(required = false) Payment payment
    ) throws Exception {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /payments : Create a new payment
     *
     * @param payment  (optional)
     * @return Payment created (status code 201)
     */
    @Operation(
        operationId = "paymentsPost",
        summary = "Create a new payment",
        responses = {
            @ApiResponse(responseCode = "201", description = "Payment created")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/payments",
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Void> paymentsPost(
        @Parameter(name = "Payment", description = "") @Valid @RequestBody(required = false) Payment payment
    ) throws Exception {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}