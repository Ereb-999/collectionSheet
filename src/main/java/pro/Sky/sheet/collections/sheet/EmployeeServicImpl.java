package pro.Sky.sheet.collections.sheet;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.*;

@Service
public abstract class EmployeeServicImpl implements EmployeeServic {

    private final Map<String, Employee> employees;

    public EmployeeServicImpl(){
        this.employees = new HashMap<>();
    }
    @Override
    public Employee add(String firstName, String lastNme, int departamentId, int salary) {
        if (!validateInput(firstName, lastNme)){
            throw new InvalitEcxeption();
        }
        Employee employee = new Employee(firstName, lastNme, departamentId, salary);
        if(employees.containsKey(employee.getFulName())){
            throw new EcxeptionRuntim();
        }
        employees.put(employee.getFulName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastNme, int departamentId, int salary) {
        if (!validateInput(firstName, lastNme)){
            throw new InvalitEcxeption();
        }
        Employee employee = new Employee(firstName, lastNme, departamentId, salary);
        if(employees.containsKey(employee.getFulName())){
            return employees.remove(employee.getFulName());
        }
        throw  new Ecxeption();
    }

    @Override
    public Employee find(String firstName, String lastNme, int departamentId, int salary) {
        if (!validateInput(firstName, lastNme)){
            throw new InvalitEcxeption();
        }
        Employee employee = new Employee(firstName, lastNme, departamentId, salary);
        if(employees.containsKey(employee.getFulName())){
            return employees.get(employee.getFulName());
        }
        throw  new Ecxeption();
    }


    @Override
    public Collection<Employee> findAll(){
        return Collections.unmodifiableCollection(employees.values());
    }

    private boolean validateInput(String firstName, String lastNme){
        return StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastNme);
    }

}
