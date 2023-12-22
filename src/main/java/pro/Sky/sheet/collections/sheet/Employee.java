package pro.Sky.sheet.collections.sheet;

import java.util.Objects;

public class Employee{
    private final String firstName;
    private final String lastName;



    public Employee(String firstName, String lastName){
        this.lastName = lastName;
        this.firstName =  firstName;


    }

    public String getFirstName(){return firstName;}
    public String getLastName() {return lastName;}

    public String getFulName() {return firstName + " " + lastName;}
    @Override
    public String toString(){
        return
                "Имя: " + firstName +
                ". Фамилия: " + lastName + ".";
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }


}
