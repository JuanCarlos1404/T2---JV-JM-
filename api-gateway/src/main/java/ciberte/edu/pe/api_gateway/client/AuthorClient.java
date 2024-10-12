package ciberte.edu.pe.api_gateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "author-service")
public interface AuthorClient {
    @GetMapping("/authors")
    List<String> getAuthors();
}
