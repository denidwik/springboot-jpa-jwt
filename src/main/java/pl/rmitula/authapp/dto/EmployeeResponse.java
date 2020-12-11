package pl.rmitula.authapp.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import pl.rmitula.authapp.model.Employee;

@Setter
@Getter
public class EmployeeResponse {
    private Page<Employee> employeeListResultPage;
    private ErrorResponse errorResponse;
}
