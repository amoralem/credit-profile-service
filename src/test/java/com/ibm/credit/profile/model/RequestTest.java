package com.ibm.credit.profile.model;

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
class RequestTest {
	
	String uid=GUIDGenerator.generateGUID();
	
	@Test
	void RequestModel() {
		try {
			Request obj=new Request();
			obj.setAge(1);
			obj.setMonthlySalary(new BigDecimal(1));
			obj.setYourPassion("xxx");
			assertNotNull(obj);
			assertNotNull(obj.getAge());
			assertNotNull(obj.getMonthlySalary());
			assertNotNull(obj.getYourPassion());			
		}catch (Exception e) {
			LogHandler.error(uid, getClass(), "Error ", e);
		}
	}

}
