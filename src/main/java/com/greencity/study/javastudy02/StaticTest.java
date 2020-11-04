package com.greencity.study.javastudy02;

public class StaticTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[4];
        staff[0] = new Employee("Tom", 4000);
        staff[1] = new Employee("Jack", 5000);
        staff[2] = new Employee("Andy", 6000);
        staff[3] = new Employee("Andy", 6000);
        for (Employee e: staff) {
            e.setId();
            System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary=" + e.getSalary());
        }
        int n = Employee.getNextId();
        System.out.println("Next available id="+n);
    }
}

class Employee{
    private static int nextId = 0;

    private String name;

    private double salary;

    private int id;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        id=0;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Employee.nextId = nextId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        id = nextId;
        nextId++;
    }

    public static void main(String[] args) {
        Employee e = new Employee("Herry", 50000);
        System.out.println(e.getName()+"     "+e.getSalary());
    }
}


