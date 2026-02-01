/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.io.qlsach.service;

/**
 *
 * @author PC
 */
import com.example.io.qlsach.model.Book;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service // Đánh dấu đây là một Service Bean để Spring quản lý
public class BookService {
    // Khởi tạo danh sách sách tạm thời (In-memory)
    private List<Book> books = new ArrayList<>();

    public BookService() {
        // Thêm một vài dữ liệu mẫu để kiểm tra
        books.add(new Book(1, "Lập trình Java", "Nguyễn Văn A"));
        books.add(new Book(2, "Spring Boot Cơ Bản", "Trần Thị B"));
    }

    // Lấy toàn bộ danh sách sách
    public List<Book> getAllBooks() {
        return books;
    }

    // Tìm sách theo ID
    public Book getBookById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Thêm sách mới
    public void addBook(Book book) {
        books.add(book);
    }
    // Thêm vào trong lớp BookService
public void updateBook(int id, Book updatedBook) {
    books.stream()
        .filter(book -> book.getId() == id)
        .findFirst()
        .ifPresent(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
        });
}

public void deleteBook(int id) {
    books.removeIf(book -> book.getId() == id);
}
}


