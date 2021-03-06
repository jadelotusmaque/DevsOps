package com.accenture.ws;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;


import com.accenture.ws.entity.*;









@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class OrderAndBillingTest {
	
	 @Autowired
     private TestRestTemplate restTemplate;
	
	  @LocalServerPort
	     private int port;

	     private String getRootUrl() {
	         return "http://localhost:" + port;
	     }
	     
	  @Test
	 public void testGetAllOrderList() {
		 
		 HttpHeaders headers = new HttpHeaders();
	        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/getorderlist",
	        HttpMethod.GET, entity, String.class);  
	        assertNotNull(response.getBody());
	    }
	 
	  @Test
	    public void testCreateOrder() {
		   Order order = new Order();
	        order.setOrderName("Espresso");
	        order.setPrice(4.5);
	        order.setDiscounted(true);
	        ResponseEntity<Order> postResponse = restTemplate.postForEntity(getRootUrl() + "/add", order, Order.class);
	        assertNotNull(postResponse);
	        assertNotNull(postResponse.getBody());
	    
	    }
	  
	  @Test
	    public void testUpdateOrder() {
	        int id = 1;
	        Order order = restTemplate.getForObject(getRootUrl() + "/updateorder/" + id, Order.class);
	        order.setOrderName("Latte1");
	        order.setPrice(5.5);
	        order.setDiscounted(false);
	        restTemplate.put(getRootUrl() + "/updateorder/" + id, order);
	        Order updatedOrder = restTemplate.getForObject(getRootUrl() + "/updateorder/" + id, Order.class);
	        assertNotNull(updatedOrder);
	    }
	  
	  @Test
	    public void testDeleteEmployee() {
	         int id = 2;
	         Order order = restTemplate.getForObject(getRootUrl() + "/deleteorderById/" + id, Order.class);
	         assertNotNull(order);
	         restTemplate.delete(getRootUrl() + "/deleteorderById/" + id);
	         try {
	              order = restTemplate.getForObject(getRootUrl() + "/deleteorderById/" + id, Order.class);
	         } catch (final HttpClientErrorException e) {
	              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
	         }
	    }
		 
	 }
	



