package com.fdmgroup.stubbingExercise;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestRectangleStatistics {
	RectangleStatistics rectangleStatistics;
	
	@Mock
	Rectangle mockRectangle;
	

	@BeforeEach
	void setUp() throws Exception {
		rectangleStatistics = new RectangleStatistics();
	}

	@Test
	void test_calculateArea_returns20_whenRectangleWithWidth4AndLength5PassedIn() {
		when(mockRectangle.getWidth()).thenReturn(4);
		when(mockRectangle.getLength()).thenReturn(5);
		
		int area = rectangleStatistics.calculateArea(mockRectangle);
		assertEquals(20, area);
	}
	
	@Test
	void test_calculateArea_returns35_whenRectangleWithWidth5AndLength7PassedIn() {
		when(mockRectangle.getWidth()).thenReturn(5);
		when(mockRectangle.getLength()).thenReturn(7);
		
		int area = rectangleStatistics.calculateArea(mockRectangle);
		assertEquals(35, area);
	}
	
	@Test
	void test_calculateCircumference_returns22_whenRectangleWithWidth3AndLength8PassedIn() {
		when(mockRectangle.getWidth()).thenReturn(3);
		when(mockRectangle.getLength()).thenReturn(8);
		
		int circumference = rectangleStatistics.calculateCircumference(mockRectangle);
		assertEquals(22, circumference);
	}
	
	@Test
	void test_calculateCircumference_returns60_whenRectangleWithWidth10AndLength20PassedIn() {
		when(mockRectangle.getWidth()).thenReturn(10);
		when(mockRectangle.getLength()).thenReturn(20);
		
		int circumference = rectangleStatistics.calculateCircumference(mockRectangle);
		assertEquals(60, circumference);
	}

}
