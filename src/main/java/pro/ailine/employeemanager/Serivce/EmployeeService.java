package pro.ailine.employeemanager.Serivce;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.ailine.employeemanager.exception.UserNotFoundException;
import pro.ailine.employeemanager.model.employee;
import pro.ailine.employeemanager.repo.EmployeeRepo;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public employee addEmployee(employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public employee updateEmployee(employee employee) {
        return employeeRepo.save(employee);
    }

    public employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }
}