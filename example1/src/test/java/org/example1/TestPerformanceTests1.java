package org.example1;

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;
import org.processor.Regression;
import org.processor.Regression.MeasurementUnit;
import org.processor.Regression.RegressionDirection;
import org.tester.RegressionTester;

public class TestPerformanceTests1 {
	
	private static RegressionTester rt;
	
	@BeforeClass
	public static void Initialize(){
		rt = new RegressionTester("C:/meas_methods.csv", "meas_output.csv");
	}

	@Test
	@Regression(treshold=3.9, rep=5)
	public void test1() {
		System.out.println("PerformanceTests1 test1 init before startMeasureTime()");
		rt.startMeasureTime();
		
		try {
			Random rand = new Random();
			int nextint = rand.nextInt(300) + 1000;
			System.out.println(nextint);
			Thread.sleep(nextint);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		rt.stopMeasureTime(this);
		System.out.println("PerformanceTests1 test1 dtor after stopMeasureTime()");
	}
	
	@Test
	@Regression(treshold=3.5,
			    dir=RegressionDirection.LESS,
			    rep=3,
			    unit=MeasurementUnit.SECOND)
	public void test2() {
		System.out.println("PerformanceTests1 test2 init before startMeasureTime()");
		rt.startMeasureTime();
		
		try {
			Thread.sleep(456);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		rt.stopMeasureTime(this);
		System.out.println("PerformanceTests1 test2 dtor after stopMeasureTime()");
	}
	
	@Test
	public void testInvoker(){
		rt.invokeTestMethods(this);
	}

}
