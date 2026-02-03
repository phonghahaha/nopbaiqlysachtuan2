/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.io.qlsach.model;

/**
 *
 * @author PC
 */

/**
 * @author PC
 */
public class Book {
    // Đổi từ int sang Long để khớp với bài giảng của thầy
    private Long id; 
    private String title;
    private String author;

    // Constructor không tham số
    public Book() {}

    // Constructor có tham số (Sửa int thành Long)
    public Book(Long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    // Getter và Setter cho ID (Sửa kiểu trả về và tham số thành Long)
    public Long getId() { 
        return id; 
    }
    
    public void setId(Long id) { 
        this.id = id; 
    }

    public String getTitle() { 
        return title; 
    }
    
    public void setTitle(String title) { 
        this.title = title; 
    }

    public String getAuthor() { 
        return author; 
    }
    
    public void setAuthor(String author) { 
        this.author = author; 
    }
}

