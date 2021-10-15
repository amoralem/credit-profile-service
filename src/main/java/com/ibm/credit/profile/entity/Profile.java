package com.ibm.credit.profile.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "profiles")
public class Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "your_passion")
	private String yourPassion;
	@Column(name = "monthly_salary_min")
	private BigDecimal monthlySalaryMin;
	@Column(name = "monthly_salary_max")
	private BigDecimal monthlySalaryMax;
	@Column(name = "age_min")
	private Integer ageMin;
	@Column(name = "age_max")
	private Integer ageMax;
	@Column(name = "credit_cards")
	private String creditCards;	

}
