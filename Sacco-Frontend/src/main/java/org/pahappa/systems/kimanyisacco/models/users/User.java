package org.pahappa.systems.kimanyisacco.models.users;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "usersTable")

public class User implements Serializable {

    private String firstname;
    private String lastname;
    private String phone;
    private String department;
    private String email;
    private Date dob;
    private String password;

    private int status;
    private Long user_id;

    @Column(name = "first_name")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
@Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
@Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "department")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
@Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getStatus() == user.getStatus() &&
                Objects.equals(getFirstname(), user.getFirstname())
                && Objects.equals(getLastname(), user.getLastname())
                && Objects.equals(getPhone(), user.getPhone())
                && Objects.equals(getDepartment(), user.getDepartment())
                && Objects.equals(getEmail(), user.getEmail())
                && Objects.equals(getDob(), user.getDob())
                && Objects.equals(getPassword(), user.getPassword())
                && Objects.equals(getUser_id(), user.getUser_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstname(), getLastname(), getPhone(), getDepartment(), getEmail(), getDob(), getPassword(), getStatus(), getUser_id());
    }

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", user_id=" + user_id +
                '}';
    }
}
