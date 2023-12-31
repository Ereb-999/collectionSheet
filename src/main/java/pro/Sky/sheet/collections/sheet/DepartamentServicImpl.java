package pro.Sky.sheet.collections.sheet;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartamentServicImpl {

    private final DepartamentServicVar departamentServicVar ;

    public DepartamentServicImpl(DepartamentServicVar departamentServicVar) {
        this.departamentServicVar = departamentServicVar;
    }

    @GetMapping("/max-salary")
    public Employee findEmployeeMaxSalaryDepartament(@RequestParam int departamentId){
        return departamentServicVar.findEmployeeMaxSalaryDepartament(departamentId);
    }

    @GetMapping("/min-salary")
    public Employee findEmployeeMinSalaryDepartament(@RequestParam int departamentId){
        return departamentServicVar.findEmployeeMinSalaryDepartament(departamentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> findEmployee(){
      return departamentServicVar.findEmployeeDepartamentNameLastName();
    }

    @GetMapping(path = "/all", params = "{departamentId}")
    public Collection<Employee> findEmployee(@RequestParam int departamentId){
        return departamentServicVar.findEmployeeDepartamentNameLastName(departamentId);
    }


}
