// students.java
package com.example.listviewpush;

public class student {
    private String fullName;
    private double grade;
    private int photo;
    private String group;

    public student(String fullName, double grade, int photo, String group) {
        this.fullName = fullName;
        this.grade = grade;
        this.photo = photo;
        this.group = group;
    }

    public String getFullName() {
        return fullName;
    }

    public double getGrade() {
        return grade;
    }

    public int getPhoto() {
        return photo;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return fullName;
    }
}