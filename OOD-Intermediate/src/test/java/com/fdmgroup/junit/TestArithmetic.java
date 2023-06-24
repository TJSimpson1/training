package com.fdmgroup.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestArithmetic {
	
	Arithmetic arithmetic;
	
	@BeforeEach
	public void setUp() {
		arithmetic = new Arithmetic();	//Arrange
	}

	@Test
	public void test_multiplyByTwo_returns4_when2PassedIn() {
		int result = arithmetic.multiplyByTwo(2);	//Act
		assertEquals(4, result);					//Assert
	}
	
	@Test
	public void test_multiplyByTwo_returns6_when3PassedIn() {
		int result = arithmetic.multiplyByTwo(3);	//Act
		assertEquals(6, result);					//Assert
	}
	
	@Test
	public void test_multiplyByTwo_returnsMinus4_whenMinus2PassedIn() {
		int result = arithmetic.multiplyByTwo(-2);	//Act
		assertEquals(-4, result);					//Assert
	}
	
	@Test
	public void test_multiplyByTwo_returns0_when0PassedIn() {
		int result = arithmetic.multiplyByTwo(0);	//Act
		assertEquals(0, result);					//Assert
	}
	
	
	
	
}
