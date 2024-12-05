package com.ust.orderservice.feign;

import com.ust.orderservice.dto.BookDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "bookservice")
public interface BookServiceClient {

    @GetMapping("/books/{id}")
    BookDTO getBookById(@PathVariable Long id);  // Make sure it returns a BookDTO object
}