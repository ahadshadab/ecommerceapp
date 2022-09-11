package com.javainusestore;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import com.javainusestore.model.Users;


@SpringBootTest(classes = SpringBootEcommerceApplication.class, 
webEnvironment = WebEnvironment.RANDOM_PORT)
class SpringBootEcommerceApplicationTests {
	
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

//	@Sql({ "classpath:schema.sql", "classpath:data.sql" })
//	@Sql({ "classpath:data.sql" })
	@Test
	public void testAllEmployees() 
	{
		assertTrue(
				this.restTemplate
					.getForObject("http://localhost:" + port + "/users/getUsers", Users.class)
					.getUserList().size() == 8);
	}
	

}
