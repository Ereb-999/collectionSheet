package pro.Sky.sheet.collections.sheet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static java.util.Collections.emptyMap;
import static java.util.Collections.singletonList;
import static org.mockito.Mockito.*;
import static pro.Sky.sheet.collections.sheet.PeremenEmployee.*;


@ExtendWith(MockitoExtension.class)
class DepartamentServicImplTest {

    @Mock
    private EmployeeServic employeeServic;

    @InjectMocks
    private DepartamentServicImpl out;

    @Test
   public void TestFindEmployeeMaxSalaryDepartament() {
        when(employeeServic.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MaxSalaryEmployee, out.findEmployeeMaxSalaryDepartament(DepartamentId));
    }
    @Test
    public void TestFindEmployeeNotFoundlist() {
        when(employeeServic.findAll()).thenReturn(Collections.emptyList());
        assertThrows(EmployeeNotFoundExeption.class,
                () -> out.findEmployeeMaxSalaryDepartament(DepartamentId));
    }
    @Test
    public void TestFindEmployeeMaxSalaryNotFoundDepartament() {
        when(employeeServic.findAll()).thenReturn(EMPLOYEES);
        assertThrows(EmployeeNotFoundExeption.class,
                () -> out.findEmployeeMaxSalaryDepartament(DepartamentId));
    }
    @Test
    public void TestFindEmployeeMinSalaryDepartament() {
        when(employeeServic.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MinSalaryEmployee, out.findEmployeeMinSalaryDepartament(DepartamentId));
    }
    @Test
    public void TestFindEmployeeMinNotFoundlist() {
        when(employeeServic.findAll()).thenReturn(Collections.emptyList());
        assertThrows(EmployeeNotFoundExeption.class,
                () -> out.findEmployeeMinSalaryDepartament(DepartamentId));
    }
    @Test
    public void TestFindEmployeeMinSalaryNotFoundDepartament() {
        when(employeeServic.findAll()).thenReturn(EMPLOYEES);
        assertThrows(EmployeeNotFoundExeption.class,
                () -> out.findEmployeeMinSalaryDepartament(DepartamentId2));
    }

    @Test
   public void TestFindEmployeeReturn() {
        when(employeeServic.findAll()).thenReturn(DifferentDepartamentEmployes);
        assertEquals(DepartamentMap, out.findEmployee());
    }


    @Test
   public void TestFindEmployeeReturnMap() {
        when(employeeServic.findAll()).thenReturn(Collections.emptyList());
        assertEquals(emptyMap(), out.findEmployee());
    }

    @Test
    public void TestFindEmployeeReturnMapDepartament(){
        when(employeeServic.findAll()).thenReturn(DifferentDepartamentEmployes);
        assertEquals(singletonList(MinSalaryEmployee), out.findEmployee(DepartamentId));
        assertEquals(singletonList(DifferentDepartamentEmployes), out.findEmployee(DepartamentId2));
    }
}