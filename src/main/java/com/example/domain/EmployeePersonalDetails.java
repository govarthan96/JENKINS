package com.example.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee_personal_details")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class EmployeePersonalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMP_DETAILS_ID")
    private  Long empDetailsId;


    @Column(name = "EMPLOYEE_BY_EMPLOYEE_ID")
    private Long employeeByEmployeeId;

    @Column(name = "FATHER_NAME")
    private String fatherName;

    @Column(name = "MOTHER_NAME")
    private String motherName;

    @Column(name = "PHONE_NO")
    private String phoneNo;

    @Column(name = "EMIL_ID")
    private String emailId;

    @Column(name = "PRESENT_CITY")
    private String presentCity;

    @Column(name = "PRESENT_COUNTRY_ID")
    private Long presentCountryID;

    @ManyToOne
    @JoinColumn(name = "PRESENT_COUNTRY_ID",referencedColumnName = "id",insertable = false, updatable = false)
    private Country country;


    @OneToOne
    @JoinColumn(name ="EMPLOYEE_BY_EMPLOYEE_ID",insertable = false, updatable = false)
    private Employee emp;
}
