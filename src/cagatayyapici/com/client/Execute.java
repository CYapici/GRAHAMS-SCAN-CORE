package cagatayyapici.com.client;

import java.util.Arrays;
import java.util.List;

import cagatayyapici.com.algorithm.GrahamsScan;
import cagatayyapici.com.vo.Vector2;

/**
 * 
 * YOUR PLAY GROUND / client
 * 
 * @author Cagatay Yapici
 *
 */
public class Execute {
	public static void main(String[] args) {
		List<Vector2> coordinates = Arrays.asList(new Vector2[] {
				new Vector2(-1, 3), new Vector2(3, 1), new Vector2(1, 1),
				new Vector2(0, -1), new Vector2(-2, 1), new Vector2(-1, 2),
				new Vector2(0, 0) });

		// find the convex hull
		List<Vector2> convexHull = new GrahamsScan().GetConvexHull(coordinates);

		for (Vector2 p : convexHull) {
			System.out.print(p.x);
			System.out.print("/");
			System.out.print(p.y);
			System.out.println();
		}
	}
}
