package com.example.demo.www.chap05;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MappingServiceTest {
	MappingService ms = new MappingService();
	
	@Test
	void testMyMap() {
		assertTrue(asList().equals(ms.myMap()));
	}
	
	@Test
	void testMyMap2() {
		assertTrue(asList().equals(ms.myMap2()));
	}

	@Test
	void testMyFlatMap() {
		assertTrue(asList().equals(ms.myFlatMap()));
	}

	@Test
	void testMyFlatMap2() {
		assertTrue(asList().equals(ms.myFlatMap2()));
	}

}
