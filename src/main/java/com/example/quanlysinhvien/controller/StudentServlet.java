package com.example.quanlysinhvien.controller;

import com.example.quanlysinhvien.model.Student;
import com.example.quanlysinhvien.service.StudentServiceImpl;
import com.example.quanlysinhvien.service.WriteRead;

import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "student", value = "/student")
public class StudentServlet extends HttpServlet {
    StudentServiceImpl studentService = new StudentServiceImpl();



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateStudentForm(request, response);
                break;
            case "edit":
                showEditStudentForm(request, response);
                break;
            case "delete":
                deleteStudent(request, response);
                break;
            case "sortByAverageScore":
                showListSortByAverageScore(request, response);
                break;
            default:
                showListStudentPage(request, response);
        }

    }

    private void showListSortByAverageScore(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/student/list.jsp");
        List<Student> studentListSortByAverageScore = new ArrayList<>(studentService.showAll());
        studentListSortByAverageScore.sort(Comparator.comparingDouble(Student::getAverageScore));
        Collections.reverse(studentListSortByAverageScore);
        request.setAttribute("studentList", studentListSortByAverageScore);
        requestDispatcher.forward(request,response);
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentService.delete(id);
        response.sendRedirect("/student");
    }

    private void showEditStudentForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/student/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findByid(id);
        request.setAttribute("studentEdit", student);
        requestDispatcher.forward(request, response);
    }

    private void showCreateStudentForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/student/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showListStudentPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/student/list.jsp");
        List<Student> studentList ;
        studentList = WriteRead.readFile();
        request.setAttribute("studentList", studentList);
        requestDispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createStudentForm(request, response);
                break;
            case "edit":
                editStudentForm(request, response);
                break;
        }
    }

    private void editStudentForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");
        double averageScore = Double.parseDouble(request.getParameter("averageScore"));
        Student student = new Student(id, name, age, sex, address, averageScore);
        studentService.edit(id, student);
        response.sendRedirect("/student");
    }

    private void createStudentForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");
        double averageScore = Double.parseDouble(request.getParameter("averageScore"));

        Student student = new Student(id, name, age, sex, address, averageScore);
        studentService.create(student);

        response.sendRedirect("/student");
    }
}