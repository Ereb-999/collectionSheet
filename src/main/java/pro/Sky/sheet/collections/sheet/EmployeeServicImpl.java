package pro.Sky.sheet.collections.sheet;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServicImpl implements EmployeeServic {

    private final Map<String, Employee> employees;

    public EmployeeServicImpl(){
        this.employees = new HashMap<>();
    }
    @Override
    public Employee add(String firstName, String lastNme) {
        Employee employee = new Employee(firstName, lastNme);
        if(employees.containsKey(employee.getFulName())){
            throw new EcxeptionRuntim();
        }
        employees.put(employee.getFulName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastNme) {
        Employee employee = new Employee(firstName, lastNme);
        if(employees.containsKey(employee.getFulName())){
            return employees.remove(employee.getFulName());
        }
        throw  new Ecxeption();
    }

    @Override
    public Employee find(String firstName, String lastNme) {
        Employee employee = new Employee(firstName, lastNme);
        if(employees.containsKey(employee.getFulName())){
            return employees.get(employee.getFulName());
        }
        throw  new Ecxeption();
    }

    @Override
    public Collection<Employee> findAll(){
        return Collections.unmodifiableCollection(employees.values());
    }
}
