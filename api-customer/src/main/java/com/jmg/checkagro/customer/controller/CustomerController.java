package com.jmg.checkagro.customer.controller;

import com.jmg.checkagro.customer.controller.mapper.CustomerMapper;
import com.jmg.checkagro.customer.controller.request.CustomerRequest;
import com.jmg.checkagro.customer.controller.response.CustomerResponse;
import com.jmg.checkagro.customer.event.ClienteCreadoEventProducer;
import com.jmg.checkagro.customer.exception.CustomerException;
import com.jmg.checkagro.customer.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerMapper customerMapper;
    private final CustomerService customerService;

    private final ClienteCreadoEventProducer clienteCreadoEventProducer;

    public CustomerController(CustomerMapper customerMapper, CustomerService customerService, ClienteCreadoEventProducer clienteCreadoEventProducer) {
        this.customerMapper = customerMapper;
        this.customerService = customerService;
        this.clienteCreadoEventProducer = clienteCreadoEventProducer;
    }


    @PostMapping
    public Map<String, String> create(@RequestBody CustomerRequest request) throws CustomerException {
        return Map.of("id", customerService.create(customerMapper.toCustomer(request)));
    }

    @PutMapping("/{id}")
    public void update(@RequestBody CustomerRequest request, @PathVariable String id) throws CustomerException {
        customerService.update(id, customerMapper.toCustomer(request));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) throws CustomerException {
        customerService.deleteById(id);
    }

    @GetMapping("/{id}")
    public CustomerResponse getById(@PathVariable String id) throws CustomerException {
        return customerMapper.toCustomerResponse(customerService.getById(id));
    }

    @PatchMapping("/clienteCreado")
    @ResponseStatus(code = HttpStatus.OK)
    public void clienteCreado(){
        clienteCreadoEventProducer.publishClienteCreado(new ClienteCreadoEventProducer.Data("DH","1234123", "21380196" ));
    }

}
