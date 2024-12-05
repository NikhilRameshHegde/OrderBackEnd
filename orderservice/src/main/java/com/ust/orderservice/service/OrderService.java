package com.ust.orderservice.service;

import com.ust.orderservice.dto.BookDTO;
import com.ust.orderservice.feign.BookServiceClient;
import com.ust.orderservice.model.OrderEntity;
import com.ust.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookServiceClient bookServiceClient;

    public OrderEntity createOrder(List<Long> bookIds) {
        double totalPrice = 0;

        // Fetch book details from Book Service and calculate the total price
        for (Long bookId : bookIds) {
            BookDTO book = bookServiceClient.getBookById(bookId);  // Correctly fetch the book details
            totalPrice += getPriceFromBookResponse(book);  // Extract price from the BookDTO
        }

        // Create and save the order
        OrderEntity order = new OrderEntity();
        order.setBookIds(bookIds);
        order.setTotalPrice(totalPrice);
        order.setCreatedDate(LocalDateTime.now());

        return orderRepository.save(order);
    }

    // Corrected method to extract price from the BookDTO
    private Double getPriceFromBookResponse(BookDTO bookResponse) {
        return bookResponse != null ? bookResponse.getPrice() : 0.0;  // Return the price of the book
    }

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderEntity getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}