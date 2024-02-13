package pro.Sky.sheet.collections.sheet;

import java.util.Collection;

public interface EmployeeServic {

   Employee add(String firstName, String lastNme, int departamentId, int salary);
   Employee remove(String firstName, String lastNme, int departamentId, int salary);
   Employee find(String firstName, String lastNme, int departamentId, int salary);
   Collection<Employee> findAll();

}
