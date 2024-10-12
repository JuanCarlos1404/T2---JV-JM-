package ciberte.edu.pe.api_gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookService {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public List<String> getBooks() {
        return Arrays.asList
                ("1984", "Harry Potter", "Cien años de soledad");
    }
    @PostMapping
    public String addBook(@RequestBody String bookTitle) {
        // Lógica para agregar un libro
        return "Libro agregado: " + bookTitle;
    }

}