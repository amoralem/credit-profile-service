package com.ibm.credit.profile.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.credit.profile.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
	
	@Query("select p from profiles p "
			+ "where LOWER(p.yourPassion) = LOWER(?1) AND "
			+ " ?2 between p.monthlySalaryMin and p.monthlySalaryMax AND "
			+ " ?3 between p.ageMin and p.ageMax")	
    Optional<Profile> findProfile(String yourPassion, BigDecimal monthlySalary, Integer age);
	
	//monthlySalaryMax=0 se traduce a un valor maximo n
	@Query("select p from profiles p "
			+ "where LOWER(p.yourPassion) = LOWER(?1) AND "
			+ " ?2 >= p.monthlySalaryMin and p.monthlySalaryMax=0 AND "
			+ " ?3 between p.ageMin and p.ageMax")	
    Optional<Profile> findProfileMonthlyMore(String yourPassion, BigDecimal monthlySalary, Integer age);

}
