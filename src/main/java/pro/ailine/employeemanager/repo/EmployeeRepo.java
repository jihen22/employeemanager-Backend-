package pro.ailine.employeemanager.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import pro.ailine.employeemanager.model.employee;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<employee, Long> {
    void deleteEmployeeById(Long id);

    Optional<employee> findEmployeeById(Long id);
}