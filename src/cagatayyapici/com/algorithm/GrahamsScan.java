package cagatayyapici.com.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import cagatayyapici.com.util.Messages;
import cagatayyapici.com.vo.LinearDirection;
import cagatayyapici.com.vo.Vector2;

/**
 * CORE OF GRAHAMS SCAN
 * @author Cagatay Yapici
 *
 */
public final class GrahamsScan {

	private PointOperations pointOperator;
	private SortFromLeftDownMost listSorter;
	private List<Vector2> sorted;

	public GrahamsScan() {
		pointOperator = null;
		listSorter = null;
		sorted = null;
	}

	/**
	 * iterate through sorted and return the stack
	 * @param points
	 * @return
	 * @throws IllegalArgumentException
	 */
	public List<Vector2> GetConvexHull(List<Vector2> points)
			throws IllegalArgumentException {
		pointOperator = new PointOperations();
		returnSortedAndValidate(points); 
		// seperate first 2 elements
		Stack<Vector2> stack = new Stack<Vector2>();
		stack.push(sorted.get(0));
		stack.push(sorted.get(1));

		// look directions of remaining points
		for (int i = 2; i < sorted.size(); i++) {

			Vector2 head = sorted.get(i);
			Vector2 middle = stack.pop();
			Vector2 tail = stack.peek();

			LinearDirection turn = pointOperator.getTurn(tail, middle, head);

			switch (turn) {
			case COUNTER_CLOCKWISE:
				stack.push(middle);
				stack.push(head);
				break;
			case CLOCKWISE:
				i--;
				break;
			case LINEAR:
				stack.push(head);
				break;
			}
		}

		// close the hull
		stack.push(sorted.get(0)); 
		return new ArrayList<Vector2>(stack);
	}

	protected void returnSortedAndValidate(List<Vector2> points) {
		if (points.size() == 0)
			throw new IllegalArgumentException(Messages.ListIsEmpty);
		sorted = new ArrayList<Vector2>(listSorter.getSortedPointSet(points));
		if (sorted.size() < 3)
			throw new IllegalArgumentException(Messages.SizeCannotBeLessThan3);
		// IF POINTS ARE LINEAR TERMINATION WILL OCCUR
		if (pointOperator.areLinearlyDependent(sorted))
			throw new IllegalArgumentException(Messages.PointsCanNotBeAllLinear);

	}

}