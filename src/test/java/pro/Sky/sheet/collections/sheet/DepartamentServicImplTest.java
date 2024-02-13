package pro.Sky.sheet.collections.sheet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static pro.Sky.sheet.collections.sheet.PeremenEmployee.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class DepartamentServicImplTest {

    @Mock
    private EmployeeServicImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl out;


    private final List<Employee> employees = List.of(
            new Employee("Василий", "Шубарев", 1, 19000),
            new Employee("Григорий", "Петрович", 1, 37900),
            new Employee("Владимир", "Сидиронка", 2, 100_000));


    @Test
    void TestFindMaxSalary() {
        when(employeeService.findAll()).thenReturn(employees);

        assertEquals(employees.get(1), out.findEmployeeMaxSalaryDepartament(DepartamentId));
    }

    @Test
    void TestFindMinSalary() {
        when(employeeService.findAll()).thenReturn(employees);

        assertEquals(employees.get(0), out.findEmployeeMinSalaryDepartament(DepartamentId));
    }

    @Test
    void TestFindMinSalaryEmployeeNotFoundException() {
        when(employeeService.findAll()).thenReturn(Collections.emptyList());

        assertThrows(EmployeeNotFoundExeption.class, () -> out.findEmployeeMinSalaryDepartament(DepartamentId));
    }

    @Test
    void TestReturnAllEmployeesInDepartment() {
        when(employeeService.findAll()).thenReturn(employees);

        assertEquals(List.of(employees.get(0), employees.get(1)), out.findEmployeeDepartamentNameLastName(DepartamentId));
    }

    @Test
    void TestGetAllEmployeesInDepartmentEmpty() {
        when(employeeService.findAll()).thenReturn(Collections.emptyList());

        assertEquals(List.of(), out.findEmployeeDepartamentNameLastName(DepartamentId));
    }

    @Test
    void TestGetAllEmployeeInDepartments() {
        when(employeeService.findAll()).thenReturn(employees);
        Map<Integer, List<Employee>> expectedMap = Map.of(
                1, List.of(employees.get(0), employees.get(1)),
                2, List.of(employees.get(2)));

        assertEquals(expectedMap, out.findEmployeeDepartamentNameLastName());
    }

    @Test
    void TestGetAllReturnEmptyListWhenEmployeeIsNotFoundInMap() {
        when(employeeService.findAll()).thenReturn(Collections.emptyList());

        assertEquals(Map.of(), out.findEmployeeDepartamentNameLastName());

    }

}