package com.ibm.credit.profile.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.credit.profile.util.GUIDGenerator;
import com.ibm.credit.profile.util.LogHandler;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ResponseTest {
	
	String uid=GUIDGenerator.generateGUID();
	
	@Test
	void RequestModel() {
		try {
			Response obj=new Response();
			obj.setCreditCards("xxxxxx");
			
			assertNotNull(obj);
			assertNotNull(obj.getCreditCards());
		}catch (Exception e) {
			LogHandler.error(uid, getClass(), "Error ", e);
		}
	}	
}
