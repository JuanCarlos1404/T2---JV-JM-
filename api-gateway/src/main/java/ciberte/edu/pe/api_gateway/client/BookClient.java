package ciberte.edu.pe.api_gateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "book-service")
public interface BookClient {
    @GetMapping("/books")
    List<String> getBooks();
}
