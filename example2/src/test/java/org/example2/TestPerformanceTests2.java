package org.example2;

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;
import org.processor.Regression;
import org.processor.Regression.MeasurementUnit;
import org.processor.Regression.RegressionDirection;
import org.tester.RegressionTester;

public class TestPerformanceTests2 {
	
	private static RegressionTester rt;
	
	@BeforeClass
	public static void Initialize(){
		rt = new RegressionTester("C:/meas_methods.csv", "meas_output.csv");
	}

	@Test
	@Regression(treshold=5, rep=5, unit=MeasurementUnit.MINUTE)
	public void test1() {
		System.out.println("PerformanceTests2 test1 init before startMeasureTime()");
		rt.startMeasureTime();
		
		try {
			Random rand = new Random();
			int nextint = rand.nextInt(3000) + 3000;
			System.out.println(nextint);
			Thread.sleep(nextint);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		rt.stopMeasureTime(this);
		System.out.println("PerformanceTests2 test1 dtor after stopMeasureTime()");
	}
	
	@Test
	public void testInvoker(){
		rt.invokeTestMethods(this);
	}

}
