/**
 * 
 */
package examples.shapes;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Keval.Shah
 *
 */
public class RectangleTest {

	@Test
	public void testValidConstruction() throws ShapeException {

		Rectangle r = new Rectangle(0, 4, 0, 0, 4, 0, 4, 4);
		assertEquals(0, r.getLine1().getPoint1().getX(), 0);
		assertEquals(0, r.getLine2().getPoint1().getX(), 0);
		assertEquals(4, r.getLine3().getPoint1().getX(), 0);
		assertEquals(4, r.getLine4().getPoint1().getX(), 0);

		Point p1 = new Point(0, 4);
		Point p2 = new Point(0, 0);
		Point p3 = new Point(4, 0);
		Point p4 = new Point(4, 4);

		r = new Rectangle(p1, p2, p3, p4);
		assertEquals(0, r.getLine1().getPoint1().getX(), 0);
		assertEquals(0, r.getLine2().getPoint1().getX(), 0);
		assertEquals(4, r.getLine3().getPoint1().getX(), 0);
		assertEquals(4, r.getLine4().getPoint1().getX(), 0);

		Line l1 = new Line(p1, p2);
		Line l2 = new Line(p2, p3);
		Line l3 = new Line(p3, p4);
		Line l4 = new Line(p4, p1);
		r = new Rectangle(l1, l2, l3, l4);
		assertEquals(0, r.getLine1().getPoint1().getX(), 0);
		assertEquals(0, r.getLine2().getPoint1().getX(), 0);
		assertEquals(4, r.getLine3().getPoint1().getX(), 0);
		assertEquals(4, r.getLine4().getPoint1().getX(), 0);

	}

	@Test
	public void testInvalidConstruction() throws Exception {

		Point p1 = new Point(0, 1);
		Point p2 = new Point(0, 0);
		Point p3 = new Point(4, 0);
		Point p4 = new Point(4, 4);

		Line l1 = new Line(p1, p2);
		Line l2 = new Line(p2, p3);
		Line l3 = new Line(p3, p4);
		Line l4 = new Line(p4, p1);
		try {
			new Rectangle(null, l2, l3, l4);
			fail("Expected exception not thrown");
		} catch (ShapeException e) {
			assertEquals("Invalid Rectangle", e.getMessage());
		}

		try {
			new Rectangle(l1, null, l3, l4);
			fail("Expected exception not thrown");
		} catch (ShapeException e) {
			assertEquals("Invalid Rectangle", e.getMessage());
		}

		try {
			new Rectangle(l1, l2, null, l4);
			fail("Expected exception not thrown");
		} catch (ShapeException e) {
			assertEquals("Invalid Rectangle", e.getMessage());
		}

		try {
			new Rectangle(l1, l2, l3, null);
			fail("Expected exception not thrown");
		} catch (ShapeException e) {
			assertEquals("Invalid Rectangle", e.getMessage());
		}

		try {
			new Rectangle(Double.POSITIVE_INFINITY, 1, 0, 0, 4, 0, 4, 4);
			fail("Expected exception not thrown");
		} catch (ShapeException e) {
			assertEquals("Invalid x-location", e.getMessage());

		}
		try {
			new Rectangle(0, Double.POSITIVE_INFINITY, 0, 0, 4, 0, 4, 4);
			fail("Expected exception not thrown");
		} catch (ShapeException e) {
			assertEquals("Invalid y-location", e.getMessage());

		}
		try {
			new Rectangle(0, 1, Double.POSITIVE_INFINITY, 0, 4, 0, 4, 4);
			fail("Expected exception not thrown");
		} catch (ShapeException e) {
			assertEquals("Invalid x-location", e.getMessage());

		}
		try {
			new Rectangle(0, 1, 0, Double.POSITIVE_INFINITY, 4, 0, 4, 4);
			fail("Expected exception not thrown");
		} catch (ShapeException e) {
			assertEquals("Invalid y-location", e.getMessage());

		}
		try {
			new Rectangle(0, 1, 0, 0, Double.POSITIVE_INFINITY, 0, 4, 4);
			fail("Expected exception not thrown");
		} catch (ShapeException e) {
			assertEquals("Invalid x-location", e.getMessage());

		}
		try {
			new Rectangle(0, 1, 0, 0, 4, Double.POSITIVE_INFINITY, 4, 4);
			fail("Expected exception not thrown");
		} catch (ShapeException e) {
			assertEquals("Invalid y-location", e.getMessage());

		}
		try {
			new Rectangle(0, 1, 0, 0, 4, 0, Double.POSITIVE_INFINITY, 4);
			fail("Expected exception not thrown");
		} catch (ShapeException e) {
			assertEquals("Invalid x-location", e.getMessage());

		}
		try {
			new Rectangle(0, 1, 0, 0, 4, 0, 4, Double.POSITIVE_INFINITY);
			fail("Expected exception not thrown");
		} catch (ShapeException e) {
			assertEquals("Invalid y-location", e.getMessage());

		}
		try {
			l4 = new Line(0, 4, 0, 4);
			new Rectangle(l1, l2, l3, l4);
			fail("Expected exception fail");
		} catch (Exception e) {
			assertEquals("A line must have a length > 0", e.getMessage());
		}
	}

	@Test
	public void TestCheckAdjacentEdgeAngle() throws ShapeException {

		try {
			Rectangle r = new Rectangle(0, 1, 0, 0, 4, 0, 4, 2);
			r.checkAdjacentEdgeAngle();
			fail("Expected exception not thrown");
		} catch (Exception e) {
			assertEquals("AdjacentEdgeAngle is not 90 degree, So its not a rectangle", e.getMessage());
		}
	}

	@Test
	public void testMove() throws ShapeException {
		Point p1 = new Point(0, 4);
		Point p2 = new Point(0, 0);
		Point p3 = new Point(4, 0);
		Point p4 = new Point(4, 4);

		Rectangle r = new Rectangle(p1, p2, p3, p4);
		r.move(2, 2);
		assertEquals(2, r.getLine1().getPoint1().getX(), 0);
	}

	@Test
	public void computeArea() throws Exception {
		Rectangle r = new Rectangle(0, 4, 0, 0, 4, 0, 4, 4);
		assertEquals(16, r.computeArea(), 0);
	}

	@Test
	public void computeHeight() throws Exception {
		Rectangle r = new Rectangle(0, 4, 0, 0, 4, 0, 4, 4);
		assertEquals(4, r.getHeight(), 0);
	}

	@Test
	public void computeWidth() throws Exception {
		Rectangle r = new Rectangle(0, 4, 0, 0, 4, 0, 4, 4);
		assertEquals(4, r.getWidth(), 0);
	}

	@Test
	public void computeVertices() throws Exception {
		Rectangle r = new Rectangle(0, 4, 0, 0, 4, 0, 4, 4);
		assertEquals(4, r.getVertices()[2].getX(), 0);
	}

	@Test
	public void computeDiagonal() throws Exception {
		Rectangle r = new Rectangle(0, 1, 0, 0, 5, 1, 5, 0);
		assertEquals(5, r.getDiagonal1(), 1);
		assertEquals(5, r.getDiagonal2(), 1);
	}

}
