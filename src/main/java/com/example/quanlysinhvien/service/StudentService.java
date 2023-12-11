package com.example.quanlysinhvien.service;

import java.io.IOException;
import java.util.List;

public interface StudentService <T>{
    List<T> showAll();
    void create(T t) throws IOException;
    void edit(int id, T t) throws IOException;
    void delete(int id) throws IOException;
    T findByid(int id);
    int findIndexById(int id);
}
