package com.johnny.restdemo;

import com.johnny.restdemo.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.BDDAssertions.then;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestDemoApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void shouldReturn200WhenSendingRequestToController() throws Exception {
        System.out.println("port:" + port);
        ResponseEntity<Employee> entity = this.testRestTemplate.getForEntity(
                "http://localhost:" + this.port + "/who", Employee.class);
        Employee employee = entity.getBody();
        System.out.println("employee = " + employee);
        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
