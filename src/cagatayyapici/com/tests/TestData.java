package cagatayyapici.com.tests;

import java.util.Arrays;
import java.util.List;

import cagatayyapici.com.vo.Vector2;

public class TestData {
	public static List<Vector2> COORDINATES = Arrays.asList(new Vector2[] {
			new Vector2(-1, 3), new Vector2(3, 1), new Vector2(1, 1),
			new Vector2(0, -1), new Vector2(-2, 1), new Vector2(-1, 2),
			new Vector2(0, 0) });

	public static List<Vector2> RIGHTRESULTS = Arrays.asList(new Vector2[] {
			new Vector2(-1, 3), new Vector2(3, 1), new Vector2(0, -1),
			new Vector2(-2, 1), new Vector2(-1, 2) });

}
