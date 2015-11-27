package cagatayyapici.com.algorithm;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import cagatayyapici.com.vo.Vector2;

/**
 * THE MAIN CONCERN IS TO GET LEFT DOWN MOST POINT TO RIGHT UP MOST POINT 
 * SORTING IS IN THIS ALGORITHM
 *  @author Cagatay Yapici
 *
 */
public class SortFromLeftDownMost {
	/**
	 * 
	 * @param points
	 * @returns if there exists multiple points returns the lowest x coordinate
	 */
	protected static Vector2 getLeftDownMost(List<Vector2> points) {
		Vector2 lowestCandidate = points.get(0);
        int len= points.size();
		for (int i = 1; i <len; i++) { 
			Vector2 temp = points.get(i); 
			if (temp.y < lowestCandidate.y || (temp.y == lowestCandidate.y && temp.x < lowestCandidate.x))
				lowestCandidate = temp; 
		}

		return lowestCandidate;
	}
	/**
	 * 
	 * @param pts
	 * 
	 * the points are sorted in increasing order of the angle they make with lowest point with x-axis
	 * 
	 * @return
	 */
		
	protected static Set<Vector2> getSortedPointSet(List<Vector2> pts) {

		final Vector2 lowest = getLeftDownMost(pts);

		TreeSet<Vector2> pointSet = new TreeSet<Vector2>(new Comparator<Vector2>() {
			@Override
			public int compare(Vector2 a, Vector2 b) { 
				if (a == b || a.equals(b))  
					return 0;  
			
				double thetaA = Math.atan2((long) a.y - lowest.y, (long) a.x
						- lowest.x);
				double thetaB = Math.atan2((long) b.y - lowest.y, (long) b.x
						- lowest.x);

				if (thetaA < thetaB)
					return -1;
				  else if (thetaA > thetaB)  
					return 1;
				 else { 
					  //case angles are same 
					 //check distance
					 //& take closest point
					double distance1 = Math
							.sqrt((((long) lowest.x - a.x) * ((long) lowest.x - a.x))
									+ (((long) lowest.y - a.y) * ((long) lowest.y - a.y)));
					double distance2 = Math
							.sqrt((((long) lowest.x - b.x) * ((long) lowest.x - b.x))
									+ (((long) lowest.y - b.y) * ((long) lowest.y - b.y)));

					if (distance1 < distance2) 
						return -1;
					  else  
						return 1;
					 
				}
			}
		});

		pointSet.addAll(pts); 
		return pointSet;
	}
}
