package com.example.quanlysinhvien.service;

import com.example.quanlysinhvien.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteRead {
    public static void saveFile(List<Student> studentList) throws IOException {
        String path = "/Users/chiuchiuleuleu/Desktop/Project/MD2/QuanLySinhVien/src/main/java/com/example/quanlysinhvien/data/student.csv";
        FileWriter fileWriter =new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "id, name, age, sex, address, average score \n";
        for (Student s : studentList) {
            str += s.getId() + "," + s.getName() + "," + s.getAge() + "," + s.getSex() + "," + s.getAddress()+ "," + s.getAverageScore() + "\n";
        }
        bufferedWriter.write(str);
        bufferedWriter.close();
        fileWriter.close();
    }

    public static List<Student> readFile() throws IOException {
        String path = "/Users/chiuchiuleuleu/Desktop/Project/MD2/QuanLySinhVien/src/main/java/com/example/quanlysinhvien/data/student.csv";
        List<Student> list = new ArrayList<>();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String content = bufferedReader.readLine();
        while ((content = bufferedReader.readLine()) != null) {
            String[] value = content.split(",");
            int studentId = Integer.parseInt(value[0]);
            String studentName = value[1];
            int age = Integer.parseInt(value[2]);
            String sex = value[3];
            String address = value[4];
            double averageScore = Double.parseDouble(value[5]);
            list.add(new Student(studentId,studentName,age,sex,address,averageScore));
        }
        bufferedReader.close();
        fileReader.close();
        return list;
    }
}
