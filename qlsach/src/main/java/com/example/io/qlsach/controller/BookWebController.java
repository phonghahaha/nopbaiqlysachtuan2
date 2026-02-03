package com.example.io.qlsach.controller;

import com.example.io.qlsach.model.Book;
import com.example.io.qlsach.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // Dùng Controller để trả về HTML
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books") // Đường dẫn dành cho giao diện Web
public class BookWebController {

    @Autowired
    private BookService bookService;

    // 1. Hiển thị danh sách sách (books.html)
    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    // 2. Hiển thị form thêm sách (add-book.html)
    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    // 3. Xử lý lưu sách mới
    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        bookService.addBook(book);
        return "redirect:/books";
    }

    // 4. Hiển thị form sửa sách (edit-book.html) - Y chang ảnh thầy
    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model) {
        bookService.getBookById(id).ifPresent(book -> 
            model.addAttribute("book", book));
        return "edit-book";
    }

    // 5. Xử lý cập nhật sách - Y chang ảnh thầy
    @PostMapping("/edit")
    public String updateBook(@ModelAttribute Book book) {
        bookService.updateBook(book);
        return "redirect:/books";
    }

    // 6. Xóa sách
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}

