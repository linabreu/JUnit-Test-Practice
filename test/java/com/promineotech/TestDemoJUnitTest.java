package com.promineotech;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.*;


class TestDemoJUnitTest {
	
	private TestDemo testDemo; //instance variable creation
	
	//create test demo object, need new testDemo before each test
	@BeforeEach
	void setUp() throws Exception
	{
		testDemo = new TestDemo();
	}
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) 
	{
		if(!expectException) 
		{
			  assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}
		else
		{
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	static Stream<Arguments> argumentsForAddPositive()
	{
			return Stream.of(
			Arguments.of(2,4,6, false),
			Arguments.of(100,10,110, false),	
			Arguments.of(1,5,6, false),
			Arguments.of(15,0,15, false), 
			Arguments.of(10,-5,5, true)); 
	}
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly()
	{
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(10, 5)).isEqualTo(15);
		assertThat(testDemo.addPositive(0, 0)).isEqualTo(0);
	}
	
	//Created own JUnitTest to test if a value below 60 will be an F grade
	@Test
	void assertThatScoreBelowSixtyIsF()
	{
		assertEquals('F', testDemo.assignLetterGrade(55));
	}
	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForGradeAssignTest")
	void assertThatGradesAreAssignedCorrectly(int score, char expectedGrade)
	{
		assertThat(testDemo.assignLetterGrade(score)).isEqualTo(expectedGrade);
	}
	
	static Stream <Arguments> argumentsForGradeAssignTest()
	{
		return Stream.of(
		Arguments.of(55, 'F'),
		Arguments.of(65, 'D'),
		Arguments.of(75, 'C'),
		Arguments.of(85, 'B'),
		Arguments.of(95, 'A'),
		Arguments.of(100, 'A'),
		Arguments.of(90, 'A'));
	}
	
	@Test
	void assertThatNumbersSquaredIsCorrect()
	{
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
	
 }
