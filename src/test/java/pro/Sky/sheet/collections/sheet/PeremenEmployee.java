package pro.Sky.sheet.collections.sheet;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;

public class PeremenEmployee {
    public static final String FirstName = "Гена";
    public static final String LastName = "Сименович";
    public static final String FirstName2 = "Петя";
    public static final String LastName2 = "Евгений";
    public static final int DepartamentId = 1;
    public static final int DepartamentId2 = 2;
    public static final int Salary = 1000;
    public static final int Salary2 = 6000;
    public static final Employee MaxSalaryEmployee = new Employee(FirstName, LastName, Salary, DepartamentId);
    public static final Employee MinSalaryEmployee = new Employee(FirstName2, LastName2, Salary2, DepartamentId2);
    public static final Set<Employee> EMPLOYEES = Set.of(MinSalaryEmployee, MaxSalaryEmployee);
    public static final Employee DifferentDepartament = new Employee(FirstName2, LastName2, Salary, DepartamentId2);
    public static final Set<Employee> DifferentDepartamentEmployes = Set.of(MinSalaryEmployee, DifferentDepartament);
    public static final Map<Integer, List<Employee>> DepartamentMap = DifferentDepartamentEmployes.stream()
            .collect(groupingBy(Employee ::getDepartamentId));
}
