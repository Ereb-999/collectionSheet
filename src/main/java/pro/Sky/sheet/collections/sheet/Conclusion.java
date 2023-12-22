package pro.Sky.sheet.collections.sheet;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;


@RestController
@RequestMapping("/Conclusion")
public class Conclusion {
    private final EmployeeServic servic;

    public Conclusion(EmployeeServic servic){
        this.servic = servic;
    }
    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastNme){
        return servic.add(firstName, lastNme);
    }

    @GetMapping("/add")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastNme){
        return servic.remove(firstName, lastNme);
    }

    @GetMapping("/add")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastNme){
        return servic.find(firstName, lastNme);
    }
    @GetMapping
    public Collection<Employee> findAll(){
        return servic.findAll();
    }

}
