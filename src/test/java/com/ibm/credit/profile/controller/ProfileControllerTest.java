package com.ibm.credit.profile.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ibm.credit.profile.mapping.Mapping;

@ExtendWith(SpringExtension.class)
@TestPropertySource(locations =
"classpath:application-test.properties")
@Sql({ "/schema-h2.sql", "/data-h2.sql"})
@SpringBootTest
class ProfileControllerTest {
	
	@Autowired
	private  WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	void getCardNotReadableException() throws Exception {
		String request="";
		
		mockMvc.perform(post(Mapping.GETCARDS).content(request)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}
	
	@Test
	void getCardArgumentNotValidException() throws Exception {
		String request="{\r\n"
				+ "    \"yourPassion\":null,\r\n"
				+ "    \"age\":null,\r\n"
				+ "    \"monthlySalary\":null\r\n"
				+ "}";
		
		mockMvc.perform(post(Mapping.GETCARDS).content(request)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}
	
	@Test
	void getCardDataExcepcion() throws Exception {
		String request="{\r\n"
				+ "    \"yourPassion\":\"shopping\",\r\n"
				+ "    \"age\":10,\r\n"
				+ "    \"monthlySalary\":6000\r\n"
				+ "}";
		
		mockMvc.perform(post(Mapping.GETCARDS).content(request)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotAcceptable());
	}
	
	@Test
	void getCardOk() throws Exception {
		String request="{\r\n"
				+ "    \"yourPassion\":\"shopping\",\r\n"
				+ "    \"age\":20,\r\n"
				+ "    \"monthlySalary\":7000\r\n"
				+ "}";
		
		mockMvc.perform(post(Mapping.GETCARDS).content(request)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	
}
