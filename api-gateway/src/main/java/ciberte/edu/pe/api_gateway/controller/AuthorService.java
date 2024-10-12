package ciberte.edu.pe.api_gateway.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorService {

    @GetMapping
    public List<String> getAuthors() {
        return Arrays.asList("George Orwell", "J.K. Rowling", "Gabriel García Márquez");
    }
    @PostMapping
    public String addAuthor(@RequestBody String authorName) {
        // Lógica para agregar un autor
        return "Autor agregado: " + authorName;
    }


}