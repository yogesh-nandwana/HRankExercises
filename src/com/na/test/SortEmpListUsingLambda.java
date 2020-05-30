package com.na.test;

import java.util.ArrayList;
import java.util.Collections;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Nandwana
 */
public class SortEmpListUsingLambda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();

        Employee emp1 = new Employee();
        emp1.setDoj(new Date());
        emp1.setName("jk");
        emp1.setId(1);
        emp1.setSalary(100000);

        Employee emp2 = new Employee();
        emp2.setDoj(new Date());
        emp2.setName("kk");
        emp2.setId(2);
        emp2.setSalary(5000);

        Employee emp3 = new Employee();
        emp3.setDoj(new Date());
        emp3.setName("Ram");
        emp3.setId(3);
        emp3.setSalary(130000);

        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);

        Collections.sort(empList, (Employee o1, Employee o2) -> o1.getName().compareTo(o2.getName()));
        System.out.println(empList);
    }
}
class Employee {
     
    private int id;
    private String name;
    private Date doj;
    private long salary;
    
     Employee() {
     }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", doj=" + doj + ", salary=" + salary + '}';
    }    
}