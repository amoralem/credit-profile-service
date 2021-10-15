package com.ibm.credit.profile.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Request {
	
	@NotNull(message = "El par\u00e1metro [yourPassion] no puede ser nulo")
	@NotEmpty(message = "El par\u00e1metro [yourPassion] no puede ser vac\u00edo")
	private String yourPassion;
	
	@NotNull(message = "El par\u00e1metro [monthlySalary] no puede ser nulo")
	private BigDecimal monthlySalary;
	
	@NotNull(message = "El par\u00e1metro [age] no puede ser nulo")	
	private Integer age;

}
