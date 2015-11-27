package cagatayyapici.com.algorithm;

import java.util.List;

import cagatayyapici.com.vo.LinearDirection;
import cagatayyapici.com.vo.Vector2;

/**
 * 
 * ABSTRACT: https://en.wikipedia.org/wiki/Linear_independence
 * 
 * @author Cagatay Yapici
 *
 */
public class PointOperations {

	/**
	 * checks whether all points are linearly independent
	 * 
	 * @param points
	 * @return
	 */

	protected boolean areLinearlyDependent(List<Vector2> points) {
		if (points.size() < 2)
			return true;

		final Vector2 a = points.get(0);
		final Vector2 b = points.get(1);
		Vector2 c;
		for (int i = 2; i < points.size(); i++) {

			c = points.get(i);

			if (getTurn(a, b, c) != LinearDirection.LINEAR)
				return false;

		}

		return true;
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	protected LinearDirection getTurn(Vector2 a, Vector2 b, Vector2 c) {
		long crossProductReslt = crossProduct(a, b, c);

		if (crossProductReslt > 0)
			return LinearDirection.COUNTER_CLOCKWISE;
		else if (crossProductReslt < 0)
			return LinearDirection.CLOCKWISE;
		else
			return LinearDirection.LINEAR;

	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return cross product result
	 */
	protected long crossProduct(Vector2 a, Vector2 b, Vector2 c) {
		return (long) ((((long) b.x - a.x) * ((long) c.y - a.y)) - (((long) b.y - a.y) * ((long) c.x - a.x)));
	}
}
