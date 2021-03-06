package ru.mongo.acl.controller;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * TODO: comment
 * @author parsentev
 * @since 24.12.2015
 */
@ContextConfiguration(locations = {"classpath:sql/security-context.xml", "classpath:sql/servlet-context.xml"})
public class ClientControllerTest extends SpringTest {

	@Override
	String getLogin() {
		return "admin";
	}

	@Override
	String getPassword() {
		return "password";
	}

	@Test
	public void testGetAll() throws Exception {
		mockMvc.perform(get("/client/")
				.contentType(APPLICATION_JSON_UTF8))
				.andDo(print())
				.andExpect(status().isOk());
	}
}