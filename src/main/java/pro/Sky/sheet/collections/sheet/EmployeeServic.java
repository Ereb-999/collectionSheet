package pro.Sky.sheet.collections.sheet;

import java.util.Collection;

public interface EmployeeServic {
   Employee add(String firstName, String lastNme);
   Employee remove(String firstName, String lastNme);
   Employee find(String firstName, String lastNme);
   Collection<Employee> findAll();

}
