package pro.Sky.sheet.collections.sheet;

import java.util.Collection;
import java.util.List;
import java.util.Map;


public interface DepartmentService {

    Employee findEmployeeMaxSalaryDepartament(int departamentId);
    Employee findEmployeeMinSalaryDepartament(int departamentId);
    Map<Integer, List<Employee>> findEmployeeDepartamentNameLastName();
    Collection<Employee> findEmployeeDepartamentNameLastName(int departamentId);

}
