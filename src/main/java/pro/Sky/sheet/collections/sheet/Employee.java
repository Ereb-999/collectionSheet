package pro.Sky.sheet.collections.sheet;

import java.util.Objects;

public class Employee{
    private final String firstName;
    private final String lastName;
    private final int departamentId;
    private int salary;



    public Employee(String firstName, String lastName, int departamentId, int salary){
        this.lastName = lastName;
        this.firstName =  firstName;
        this.departamentId = departamentId;
        this.salary = salary;

    }

    public String getFirstName(){return firstName;}
    public String getLastName() {return lastName;}
    public int getDepartamentId() {
        return departamentId;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }


    public String getFulName() {return firstName + " " + lastName;}

    @Override
    public String toString(){
        return
                "Имя: " + firstName +
                ". Фамилия: " + lastName +
                        ". Отдел: " + departamentId +
                        ". Зароботная плата: " + salary + ".";
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(departamentId, employee.departamentId) &&
                Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, departamentId, salary);
    }


}
