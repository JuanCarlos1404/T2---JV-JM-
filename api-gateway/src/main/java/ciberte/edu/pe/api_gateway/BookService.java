package ciberte.edu.pe.api_gateway;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookService {

    @GetMapping
    public List<String> getBooks() {
        return Arrays.asList("1984", "Harry Potter", "Cien años de soledad");
    }
    @PostMapping
    public String addBook(@RequestBody String bookTitle) {
        // Lógica para agregar un libro
        return "Libro agregado: " + bookTitle;
    }
}