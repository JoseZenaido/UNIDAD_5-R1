package mx.utng.practice.repository;


import java.util.List;

import javax.persistence.EntityManager;

import mx.utng.practice.model.Customer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection=EmbeddedDatabaseConnection.H2, replace=Replace.ANY)
public class TestRepository {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private EntityManager entityManager;
	@Test
	public void testSave(){
		Customer customer = new Customer("Chencho Placencia");
		Customer custSaved = customerRepository.save(customer);
		Assert.assertNotNull(custSaved);
	}
	@Test
	public void testFindAll(){
		Customer customer1 = new Customer("Chencho Placencia");
		entityManager.persist(customer1);
		Customer customer2 = new Customer("Chencho Placencia");
		entityManager.persist(customer2);
		
		List<Customer> customer = customerRepository.findAll();		
		assertThat(customer.get(0).getName()).isEqualTo(customer1.getName());
		assertThat(customer.get(1).getName()).isEqualTo(customer2.getName());
	}
	
}///
