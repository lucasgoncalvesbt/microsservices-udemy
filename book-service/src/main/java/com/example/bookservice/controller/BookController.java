package com.example.bookservice.controller;

import com.example.bookservice.Proxy.CambioProxy;
import com.example.bookservice.model.Book;
import com.example.bookservice.repository.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Book Endpoint")
@RestController
@RequestMapping("/book-service")
public class BookController {

    private final Environment environment;
    private final BookRepository repository;
    private final CambioProxy proxy;

    public BookController(Environment environment, BookRepository repository, CambioProxy proxy) {
        this.environment = environment;
        this.repository = repository;
        this.proxy = proxy;
    }

    @Operation(summary = "Find specific book by id")
    @GetMapping("/{id}/{currency}")
    public Book findBook(
            @PathVariable Long id,
            @PathVariable String currency
    ) {

        var book = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        var cambio = proxy.getCambio(book.getPrice(), "USD", currency);

        var port = environment.getProperty("local.server.port");
        book.setEnvironment(port + "FC");
        book.setCurrency(currency);
        book.setPrice(cambio.getConvertedValue());
        return book;
    }

}
