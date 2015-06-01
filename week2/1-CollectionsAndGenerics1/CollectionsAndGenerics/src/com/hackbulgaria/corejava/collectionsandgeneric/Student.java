package com.hackbulgaria.corejava.collectionsandgeneric;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student implements Comparator<Student>,Comparable<Student> {
    private String name;
    private int grade;
    
    Student(){
        
    }
    
    public Student(String name, int grade) {
        super();
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(byte grade) {
        if(grade>=2 && grade<=6){
        this.grade = grade;
        }
        else 
            throw new IllegalArgumentException("Invalid grade");
    }
   
    @Override
    public String toString() {
        return  name + ", " + grade + "\n";
    }

    @Override
    public int compareTo(Student student) {
        return this.getName().compareTo(student.getName());
    }

    @Override
    public int compare(Student firstStudent, Student secondStudent) {
        int gradeDiff= firstStudent.getGrade()-secondStudent.getGrade();
        if(gradeDiff==0){
            return firstStudent.getName().compareTo(secondStudent.getName());
        }
        else{
            return gradeDiff;
        }
        
    }
    
    public static void sortStudents(List<Student> students){
        Collections.sort(students,new Student());
        System.out.println(students);
        
    }
    public static void main(String[] args) {
        
            Student st1 = new Student("Pesho", 6);
            Student st2 = new Student("Gosho", 3);
            Student st3 = new Student("Tosho", 4);
            List<Student> list = new ArrayList<Student>();
            list.add(st1);
            list.add(st2);
            list.add(st3);
            sortStudents(list); 
        

    }



}
