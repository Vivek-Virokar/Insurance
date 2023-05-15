package com.cybage.genworth.insurance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.cybage.genworth.insurance.model.Policy;
import com.cybage.genworth.insurance.repository.PolicyRepository;
import com.cybage.genworth.insurance.service.PolicyService;
import com.cybage.genworth.insurance.serviceImpl.PolicyServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PolicyServiceImplTest {

	@InjectMocks
	PolicyServiceImpl policyService;

	@Mock
	PolicyRepository policyRepository;

	@Test
	public void savePolicyTest() {
		Policy policy = new Policy(5, "8877", "1000", "ram", "ram@gmail.com", "5012", "active");
		when(policyRepository.save(policy)).thenReturn(policy);
		Policy policyActual = policyService.savePolicy(policy);
		assertEquals(policy, policyActual);
	}

	@Test
	public void getAllPolicyTest() {
		String listOfCustomers= "customer-list";
		List<Policy> list = new ArrayList<>();
		Policy policy1 = new Policy(1, "101", "1000", "Ram", "ram@gmail.com", "2020", "active");
		Policy policy2 = new Policy(2, "102", "2000", "Shyam", "shyam@gmail.com", "2021", "active");
		Policy policy3 = new Policy(3, "103", "3000", "Rahul", "rahul@gmail.com", "2022", "active");

		list.add(policy1);
		list.add(policy2);
		list.add(policy3);

		when(policyRepository.findAll()).thenReturn(list);

		Iterable<Policy> policyList = policyService.getAllPolicy();
		assertEquals(list, policyList);

	}

	@Test
	public void getPolicyByIdTest() {
		Policy policy = new Policy(3, "103", "1000", "Shyam", "shyam@gmail.com", "2022", "active");
		Policy policy2 = new Policy(4, "8877", "1000", "ram", "ram@gmail.com", "5012", "active");

		when(policyRepository.findById(3)).thenReturn(policy);
		Policy policyActual = policyService.getPolicyById(3);
		// assertEquals("103", policyActual.getPolicyNumber());
		// assertEquals("Shyam", policyActual.getName());
		// assertEquals("active", policyActual.getStatus());
		assertEquals(policy, policyActual);

	}

/*@Before
public void beforeEachTest() {
		System.out.println("before each test case..");
	}*/

@After
public void afterEachTest() {
	System.out.println("after each test case..");
}


public void beforeAllTest() {
	System.out.println("before All test cases..");
}

	
	@Test
	public void deletePolicyTest() {
		Policy policy = new Policy(2, "103", "10000", "LIC", "abc@gmail.com", "1010", "Active");
		//Policy policy1 = new Policy(5, "111", "20000", "HDFCLife", "abc@gmail.com", "1111", "Active");
		policyRepository.save(policy);

		policyRepository.deleteById(2);

		Policy actual = policyService.deletePolicy(2);
		assertEquals(policy, actual);

	}

}
