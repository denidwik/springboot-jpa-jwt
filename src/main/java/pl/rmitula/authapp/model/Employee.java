package pl.rmitula.authapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "mst_employee")
public class Employee {

    @Id
    UUID employeeId = UUID.randomUUID();

    String name;

    String fullName;

    String email;

    String phoneNumber;

    String birthDate;
}
