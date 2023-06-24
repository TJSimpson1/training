package com.fdmgroup.stubbingExercise;

public class RectangleStatistics {

	public int calculateArea(Rectangle rectangle) {
		
		return rectangle.getLength() * rectangle.getWidth();
	}

	public int calculateCircumference(Rectangle rectangle) {
		
		return 2 * rectangle.getLength() + 2 * rectangle.getWidth();
	}

}
