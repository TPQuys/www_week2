package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.enums.EnumEmployee;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long employeeId;
    @Column(name = "full_name", length = 200,nullable = false)
    private String fullName;
    @Column(length = 150,nullable = false)
    private String dob;
    @Column(length = 150,unique = true)
    private String email;
    @Column(length = 15,nullable = false)
    private String phone;
    @Column(length = 300,nullable = false)
    private String address;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status",nullable = false)
    private EnumEmployee status;

//    @OneToMany(mappedBy = "empId")
//    private List<Order> dsOr;

    public Employee(String fullName, String dob, String email, String phone, String address, EnumEmployee statu) {
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = statu;
    }

    public Employee() {

    }

    public Employee(String name, Date dob, String email, String phone, String address) {
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EnumEmployee getStatus() {
        return status;
    }

    public void setStatus(EnumEmployee status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" +
                "\"employeeId\":" + employeeId +
                ",\"fullName\":\"" + fullName + '\"' +
                ",\"dob\":\"" + dob + '\"' +
                ",\"email\":\"" + email + '\"' +
                ",\"phone\":\"" + phone + '\"' +
                ",\"address\":\"" + address + '\"' +
                ",\"status\":\"" + status + "\"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId) && Objects.equals(fullName, employee.fullName) && Objects.equals(dob, employee.dob) && Objects.equals(email, employee.email) && Objects.equals(phone, employee.phone) && Objects.equals(address, employee.address) && status == employee.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, fullName, dob, email, phone, address, status);
    }
}
