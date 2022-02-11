package com.terrapay.entity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="users")
public class User extends Auditable{
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "First name is required")
	@Column(name="first_name", length=40)
	private String firstName;
	
	@NotNull(message = "Last name is required")
	@Column(name="last_name",length=40)
	private String lastName;
	
	@Column(name="gender",length=10)
	private String gender;
	
	@NotNull(message = "Date of birth is required")
	@Column(name="dob")
	private Date dob;
	
	@NotNull(message = "Address is required")
	@Column(name="address",length=40)
	private String address;
	
	@Email(message = "Please enter valid email", regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
	 @NotNull(message = "Please enter email")
	@Column(name="email", unique = true)
	private String email;
	
	 @NotNull
	 @Size(max = 10, message = "Mobile number should be 10 digits")
	@Column(name="phone_number")
	private String phone;
	 
	@NotNull(message = "Admission  or joining date required")
	@Column(name="dojOrAdmission_date")
	private Date dojOrAdmissionDate;
	
	@Column(name="salaryOrfees")
	private long salaryOrFees;
	
	@NotNull
	@Size(max = 8, message = "Insert password maximum 8 characters")
	@Column(name="password")
	private String password;
	
	private Integer role_Id;
	
	private String role;
	
	

//	 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	    @JoinTable(name = "user_roles",
//	        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
//	        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
//	    private Collection<Role> role;
   

	
}
