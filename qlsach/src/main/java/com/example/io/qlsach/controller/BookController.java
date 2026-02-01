/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.io.qlsach.controller;

/**
 *
 * @author PC
 */
import com.example.io.qlsach.model.Book;
import com.example.io.qlsach.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Đánh dấu lớp này xử lý các yêu cầu Web (Restful API)
@RequestMapping("/api/books") // Đường dẫn gốc cho các chức năng về sách
public class BookController {

    @Autowired // Tự động kết nối với BookService đã tạo ở trên
    private BookService bookService;

    // API lấy danh sách tất cả các sách
    // Bạn có thể truy cập qua: http://localhost:8080/api/books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // API lấy thông tin một cuốn sách theo ID
    // Ví dụ: http://localhost:8080/api/books/1
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }
    // Thêm vào trong lớp BookController
@PostMapping // Thêm mới sách
public String addBook(@RequestBody Book book) {
    bookService.addBook(book);
    return "Thêm sách thành công!";
}

@PutMapping("/{id}") // Cập nhật sách theo ID
public String updateBook(@PathVariable int id, @RequestBody Book book) {
    bookService.updateBook(id, book);
    return "Cập nhật sách ID " + id + " thành công!";
}

@DeleteMapping("/{id}") // Xóa sách theo ID
public String deleteBook(@PathVariable int id) {
    bookService.deleteBook(id);
    return "Xóa sách ID " + id + " thành công!";
}
}


