package ciberte.edu.pe.api_gateway.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderService {


    @GetMapping
    public List<String> getOrders() {
        return Arrays.asList("Order1", "Order2");
    }
    @PostMapping
    public String createOrder(@RequestBody String orderDetails) {
        // Lógica para crear un pedido
        return "Pedido creado: " + orderDetails;
    }
}