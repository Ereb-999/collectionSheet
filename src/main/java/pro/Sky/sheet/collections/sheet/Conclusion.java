package pro.Sky.sheet.collections.sheet;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping("/Conclusion")
public class Conclusion {
    private final EmployeeServic servic;

    public Conclusion(EmployeeServic servic){
        this.servic = servic;
    }
    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastNme,
                                @RequestParam Integer departament, @RequestParam Integer salary){
        return servic.add(firstName, lastNme, departament, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastNme,
                                   @RequestParam Integer departament, @RequestParam Integer salary){
        return servic.remove(firstName, lastNme, departament, salary);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastNme,
                                 @RequestParam Integer departament, @RequestParam Integer salary){
        return servic.find(firstName, lastNme, departament, salary);
    }
    @GetMapping
    public Collection<Employee> findAll(){
        return servic.findAll();
    }

}
