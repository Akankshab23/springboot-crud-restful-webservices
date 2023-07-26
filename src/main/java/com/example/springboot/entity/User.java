package com.example.springboot.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")

public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @NotNull
  @Size(min = 2, massage = "First Name should have atleast 2 characters")
  @Column(name = "first_name" , nullable = false)
  private String firstname;
  
  @NotNull
  @Size(min = 2, massage = "Last Name should have atleast 2 characters")
  @Column(name = "last_name", nullable = false)
  private String lastname;
  
  @Email
  @NotBlank
  @Column(name = "email", nullable = false)
  private String email;
  
  public User() {
	  
  }
  public User(String firstname, String lastname, String email) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
  }
  public long getId() {
	return id;
  }
  public void setId(long id) {
	this.id = id;
  }
  public String getFirstname() {
	return firstname;
  }
  public void setFirstname(String firstname) {
	this.firstname = firstname;
  }
  public String getLastname() {
	return lastname;
  }
  public void setLastname(String lastname) {
	this.lastname = lastname;
  }
  
  public String getEmail() {
	return email;
  }
  public void setEmail(String email) {
	this.email = email;
  }
    
}
