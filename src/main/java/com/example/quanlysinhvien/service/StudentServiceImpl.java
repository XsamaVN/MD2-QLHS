package com.example.quanlysinhvien.service;

import com.example.quanlysinhvien.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService<Student> {
    List<Student> studentList;

    public StudentServiceImpl() {
        studentList = new ArrayList<>();
    }

    @Override
    public List<Student> showAll() {
        return studentList;
    }

    @Override
    public void create(Student student) throws IOException {
        studentList.add(student);
        WriteRead.saveFile(studentList);
    }

    @Override
    public void edit(int id, Student student) throws IOException {
        int indexOf = findIndexById(id);
        studentList.set(indexOf, student);
        WriteRead.saveFile(studentList);
    }

    @Override
    public void delete(int id) throws IOException {
        int indexOf = findIndexById(id);
        studentList.remove(indexOf);
        WriteRead.saveFile(studentList);
    }

    @Override
    public Student findByid(int id) {
        int indexOf = findIndexById(id);
        return studentList.get(indexOf);
    }

    @Override
    public int findIndexById(int id) {
        int index = -1;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                index = i;
            }
        }
        return index;
    }

}
