package cagatayyapici.com.tests;

import static org.junit.Assert.fail;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import cagatayyapici.com.algorithm.GrahamsScan;
import cagatayyapici.com.vo.Vector2;

/**
 * TestData.RIGHTRESULTS are correct results TestData.COORDINATES are input
 * parameters
 * 
 * @author Cagatay Yapici
 *
 */
public class TestAlgorithm {
	 
	@Test
	public void case1() {

		// Arrange
		GrahamsScan gs = new GrahamsScan();

		// Act
		List<Vector2> hullPoints = gs.GetConvexHull(TestData.COORDINATES);
		int rightResultLen = TestData.RIGHTRESULTS.size();
		int testResultLen = hullPoints.size();
		// 0.0625
		// 0.0625
		// 0.0

		// Assert
		if (rightResultLen != testResultLen)
			fail("wrong result size..");

		for (int i = 0; i < rightResultLen; i++)
			Assert.assertEquals(hullPoints.get(i), TestData.RIGHTRESULTS.get(i));

		/**
		 * 
		 * implement your own here
		 * 
		 */

		// // start with creating points
		// List<Vector2> COORDINATES = Arrays.asList(new Vector2[] {
		// new Vector2(-1, 3), new Vector2(3, 1), new Vector2(1, 1),
		// new Vector2(0, -1), new Vector2(-2, 1), new Vector2(-1, 2),
		// new Vector2(0, 0) });
	}

}
