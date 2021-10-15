package com.ibm.credit.profile.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.credit.profile.model.Request;
import com.ibm.credit.profile.util.GUIDGenerator;
import com.ibm.credit.profile.util.LogHandler;

@ExtendWith(SpringExtension.class)
@TestPropertySource(locations =
"classpath:application-test.properties")
@Sql({ "/schema-h2.sql", "/data-h2.sql"})
@SpringBootTest
class ProfileServiceTest {
	
	@Autowired
	IProfileService profileService;
	
	String uid=GUIDGenerator.generateGUID();	
	
	@Test
	void getCardsShoppingRangeMonthly1RangeAge1() {
		try {
			Request obj=new Request("Shopping",new BigDecimal(7000),17);
			
			assertNotNull(profileService.getCard(uid, obj));
		}catch (Exception e) {
			LogHandler.error(uid, getClass(), "Error ", e);
		}
	}
	
	@Test
	void getCardsShoppingRangeMonthly1RangeAge2() {
		try {
			Request obj=new Request("Shopping",new BigDecimal(14999),25);
			
			assertNotNull(profileService.getCard(uid, obj));
		}catch (Exception e) {
			LogHandler.error(uid, getClass(), "Error ", e);
		}
	}
	
	@Test
	void getCardsShoppingRangeMonthly1RangeAge3() {
		try {
			Request obj=new Request("Shopping",new BigDecimal(7000),50);
			
			assertNotNull(profileService.getCard(uid, obj));
		}catch (Exception e) {
			LogHandler.error(uid, getClass(), "Error ", e);
		}
	}
	
}
