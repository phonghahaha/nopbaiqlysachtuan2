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
import java.util.Optional;


@Service // Đánh dấu đây là một Service Bean để Spring quản lý
public class BookService {
    // Khởi tạo danh sách sách tạm thời (In-memory)
    private List<Book> books = new ArrayList<>();
    private Long nextId = 1L; // Biến để tự động tăng ID giống bài thầy

    public BookService() {
        // Dữ liệu mẫu (sử dụng 1L, 2L để biểu thị kiểu Long)
        books.add(new Book(nextId++, "Lập trình Java", "Nguyễn Văn A"));
        books.add(new Book(nextId++, "Spring Boot Cơ Bản", "Trần Thị B"));
    }

    // Lấy toàn bộ danh sách sách
    public List<Book> getAllBooks() {
        return books;
    }

    // Tìm sách theo ID - Trả về Optional giống y chang ảnh thầy
    public Optional<Book> getBookById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }

    // Thêm sách mới
    public void addBook(Book book) {
        book.setId(nextId++); // Gán ID tự động tăng trước khi thêm
        books.add(book);
    }

    // Cập nhật sách - Sửa int thành Long
    public void updateBook(Book updatedBook) {
        books.stream()
            .filter(book -> book.getId().equals(updatedBook.getId()))
            .findFirst()
            .ifPresent(book -> {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
            });
    }

    // Xóa sách - Sửa int thành Long
    public void deleteBook(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}



