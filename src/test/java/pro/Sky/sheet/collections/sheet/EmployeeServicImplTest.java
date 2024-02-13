package pro.Sky.sheet.collections.sheet;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static pro.Sky.sheet.collections.sheet.PeremenEmployee.*;

class EmployeeServicImplTest {

    private final EmployeeServic out = new EmployeeServicImpl();

    @Test
    void TestAddEmployeeServic(){
        Employee excperement = new Employee(FirstName, LastName, Salary, DepartamentId);
        assertEquals(0,out.findAll().size());
        assertFalse(out.findAll().contains(excperement));

        Employee actual = out.add(FirstName, LastName, Salary, DepartamentId);
        assertEquals(excperement, actual);
        assertEquals(1,out.findAll().size());
        assertTrue(out.findAll().contains(excperement));
    }

    @Test
    void TestThrowEmployeeServic() {
        Employee excperement = out.add(FirstName, LastName, Salary, DepartamentId);
        assertTrue(out.findAll().contains(excperement));
        assertThrows(EcxeptionRuntim.class,
                () -> out.add(FirstName, LastName, Salary, DepartamentId));
    }
    @Test
    void TestFindEmployeeServic() {
        Employee experement = out.add(FirstName, LastName, Salary, DepartamentId);
        assertEquals(experement, out.find(FirstName, LastName, Salary, DepartamentId));
    }

    @Test
    void TestThrowNotEmployeeServic() {
        assertEquals(0,out.findAll().size());
        assertThrows(EmployeeNotFoundExeption.class, () -> out.find(FirstName, LastName, Salary, DepartamentId));
    }

    @Test
    void TestRemoveEmployeeServic() {
        Employee experement = out.add(FirstName, LastName, Salary, DepartamentId);
        assertEquals(1,out.findAll().size());
        assertTrue(out.findAll().contains(experement));

        Employee actual = out.remove(FirstName, LastName, Salary, DepartamentId);
        assertEquals(experement, actual);
        assertTrue(out.findAll().isEmpty());
        assertFalse(out.findAll().contains(experement));
    }
     @Test
    public void TestReturnEmployeeServic(){
        assertIterableEquals(Collections.emptyList(), out.findAll());
    }
    @Test
    public void TestReturnListEmployeeServic(){
       Employee employee = out.add(FirstName,LastName,Salary,DepartamentId);
       Employee employee2 = out.add(FirstName2,LastName2,Salary2,DepartamentId2);
       Collection<Employee> experement = List.of(employee, employee2);
       Collection<Employee> actual = out.findAll();
       assertIterableEquals(experement, actual);
    }
}