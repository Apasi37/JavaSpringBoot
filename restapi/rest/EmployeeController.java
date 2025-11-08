package sk.ukf.restapi.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import sk.ukf.restapi.entity.Employee;
import sk.ukf.restapi.exception.EmailAlreadyExistsException;
import sk.ukf.restapi.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService EmployeeService;

    @Autowired
    public EmployeeController(EmployeeService EmployeeService) {
        this.EmployeeService = EmployeeService;
    }

    @Value("${job_titles}")
    private List<String> job_titles;

    @Value("${full_time}")
    private List<String> full_time;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }


    @GetMapping
    public String findAll(Model model) {
        List<Employee> Employees = EmployeeService.findAll();
        model.addAttribute("employees", Employees);
        return "employees/list";
    }

    @GetMapping("/{id}")
    public String viewEmployee(@PathVariable int id, Model model) {
        Employee Employee = EmployeeService.findById(id);
        model.addAttribute("employee", Employee);
        return "employees/view";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("job_titles", job_titles);
        model.addAttribute("full_time", full_time);
        return "employees/form";
    }

    /*
    @PostMapping
    public String createEmployee(@ModelAttribute("employee") Employee Employee) {
        EmployeeService.save(Employee);
        return "redirect:/employees";
    }
    */

    @PostMapping
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee Employee, BindingResult bindingResult, Model model) throws JsonProcessingException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("job_titles", job_titles);
            model.addAttribute("full_time", full_time);
            return "employees/form";
        }

        try {
            EmployeeService.save(Employee);
            return "redirect:/employees";
        } catch (EmailAlreadyExistsException ex) {
            bindingResult.rejectValue("email", "email.exists", ex.getMessage());
            model.addAttribute("job_titles", job_titles);
            model.addAttribute("full_time", full_time);
            return "employees/form";
        }
    }

    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable int id, Model model) {
        Employee employee = EmployeeService.findById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("job_titles", job_titles);
        model.addAttribute("full_time", full_time);
        return "employees/form";
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        EmployeeService.deleteById(id);
        return "redirect:/employees";
    }
}
