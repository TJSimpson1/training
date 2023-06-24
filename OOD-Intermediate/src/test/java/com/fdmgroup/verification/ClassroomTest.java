package com.fdmgroup.verification;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClassroomTest {
	
	Classroom classroom;
	List<Trainee> traineeList3;
	List<Trainee> traineeList5;
	
	@Mock
	Trainer mockTrainer;
	
	@Mock
	Trainee mockTrainee1, mockTrainee2, mockTrainee3, mockTrainee4, mockTrainee5;

	
	@BeforeEach
	void setUp() throws Exception {
		classroom = new Classroom();
		classroom.setTrainer(mockTrainer);	
		traineeList3 = new ArrayList<>(Arrays.asList(mockTrainee1, mockTrainee2, mockTrainee3));
		traineeList5 = new ArrayList<>(Arrays.asList(mockTrainee1, mockTrainee2, mockTrainee3, mockTrainee4, mockTrainee5));
	}

	@Test
	void test_startLesson_callsMockTrainerTeachMethod() {
		classroom.startLesson(); //Act
		verify(mockTrainer).teach();
		
	}
	
	@Test
	void test_endLesson_callsMockTrainerPrepareLessonMethod() {
		classroom.endLesson(); //Act
		verify(mockTrainer).prepareLesson();
		
	}
	
	@Test
	void test_startExam_callsMockTrainerInvigilateExamMethod() {
		classroom.startExam("Java"); //Act
		verify(mockTrainer).invigilateExam("Java");
		
	}
	
	@Test
	void test_reviewAllTraineesCode_callsMockTrainerReviewAllCodeMethod3Times_whenPassingInListOfTraineesOfSize3() {
		classroom.setTrainees(traineeList3);
		
		classroom.reviewAllTraineesCode(); //Act
		
		verify(mockTrainer, times(3)).reviewTraineeCode(any(Trainee.class));
	}
	
	@Test
	void test_reviewAllTraineesCode_callsMockTrainerReviewAllCodeMethod5Times_whenPassingInListOfTraineesOfSize5() {
		classroom.setTrainees(traineeList5);
		
		classroom.reviewAllTraineesCode(); //Act
		
		verify(mockTrainer, times(5)).reviewTraineeCode(any(Trainee.class));
	}
	
	@Test
	void test_startLesson_callsMockTraineeLearnMethod3Times_whenPassingInListOfTraineesOfSize3() {
		classroom.setTrainees(traineeList3);
		
		classroom.startLesson(); //Act
		
		verify(mockTrainee1).learn();
		verify(mockTrainee2).learn();
		verify(mockTrainee3).learn();
	}
	
	@Test
	void test_startLesson_callsMockTraineeLearnMethod5Times_whenPassingInListOfTraineesOfSize5() {
		classroom.setTrainees(traineeList5);
		
		classroom.startLesson(); //Act
		
		verify(mockTrainee1).learn();
		verify(mockTrainee2).learn();
		verify(mockTrainee3).learn();
		verify(mockTrainee4).learn();
		verify(mockTrainee5).learn();
	}

}
