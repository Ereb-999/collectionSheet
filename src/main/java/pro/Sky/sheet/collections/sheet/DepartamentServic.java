package pro.Sky.sheet.collections.sheet;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public abstract class DepartamentServic implements DepartamentServicVar {
    private final EmployeeServic employeeServic;

    public DepartamentServic(EmployeeServic employeeServic){
        this.employeeServic = employeeServic;
    }

    @Override
    public Employee findEmployeeMaxSalaryDepartament(int departamentId) {
        return employeeServic
                .findAll()
                .stream()
                .filter(e -> e.getDepartamentId() == departamentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundExeption::new);
    }

    @Override
    public Employee findEmployeeMinSalaryDepartament(int departamentId) {
        return employeeServic
                .findAll()
                .stream()
                .filter(e -> e.getDepartamentId() == departamentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundExeption::new);
    }

    @Override
    public Map<Integer, List<Employee>> findEmployeeDepartamentNameLastName(){
        return employeeServic.findAll().stream()
                .sorted(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getFulName))
                .collect(Collectors.groupingBy(Employee::getDepartamentId));
    }

    @Override
    public Collection<Employee> findEmployeeDepartamentNameLastName(int departamentId){
        return employeeServic.findAll().stream()
                .filter(e-> e.getDepartamentId() == departamentId)
                .sorted(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName))
                .collect(Collectors.toList());
    }



}
