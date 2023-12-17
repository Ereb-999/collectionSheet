package pro.Sky.sheet.collections.sheet;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServicImpl implements EmployeeServic {

    private final List<Employee> employeeList;

    public EmployeeServicImpl(){
        this.employeeList = new ArrayList<>();
    }
    @Override
    public Employee add(String firstName, String lastNme) {
        Employee employee = new Employee(firstName, lastNme);
        if(employeeList.contains(employee)){
            throw new EcxeptionRuntim();
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastNme) {
        Employee employee = new Employee(firstName, lastNme);
        if(employeeList.contains(employee)){
            employeeList.remove(employee);
        }
        throw  new Ecxeption();
    }

    @Override
    public Employee find(String firstName, String lastNme) {
        Employee employee = new Employee(firstName, lastNme);
        if(employeeList.contains(employee)){
            return employee;
        }
        throw  new Ecxeption();
    }

    @Override
    public Collection<Employee> findAll(){
        return Collections.unmodifiableList(employeeList);
    }
}
