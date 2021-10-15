package com.ibm.credit.profile.entity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.credit.profile.util.GUIDGenerator;
import com.ibm.credit.profile.util.LogHandler;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProfileTest {	
	
	String uid=GUIDGenerator.generateGUID();
	
	@Test
	void RequestModel() {
		try {
			Profile obj=new Profile();
			obj.setAgeMax(2);
			obj.setAgeMin(1);
			obj.setCreditCards("xxxx");
			obj.setId(1l);
			obj.setMonthlySalaryMax(new BigDecimal(2));
			obj.setMonthlySalaryMin(new BigDecimal(1));
			obj.setYourPassion("xxxx");
			
			assertNotNull(obj);
			assertNotNull(obj.getAgeMax());
			assertNotNull(obj.getAgeMin());
			assertNotNull(obj.getCreditCards());
			assertNotNull(obj.getId());
			assertNotNull(obj.getMonthlySalaryMax());
			assertNotNull(obj.getMonthlySalaryMin());
			assertNotNull(obj.getYourPassion());
			
		}catch (Exception e) {
			LogHandler.error(uid, getClass(), "Error ", e);
		}
	}

}
