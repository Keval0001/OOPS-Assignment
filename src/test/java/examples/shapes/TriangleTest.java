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
public class TriangleTest {
	@Test
	public void testValidConstruction() throws ShapeException {

		// Triangle via Triangle 3rd constructor, line 1 constructor and point.
		// Passing line 1,2,3
		Line l1 = new Line(2, 3, 1, 1);
		Line l2 = new Line(1, 1, 3, 1);
		Line l3 = new Line(3, 1, 2, 3);
		Triangle t2 = new Triangle(l1, l2, l3);
		assertSame(l1, t2.getLine1());
		assertSame(l2, t2.getLine2());
		assertSame(l3, t2.getLine3());

		// Triangle via Triangle 2nd constructor, line 2nd constructor and
		// point. Passing point 1,2,3
		Point p1 = new Point(2, 3);
		Point p2 = new Point(1, 1);
		Point p3 = new Point(3, 1);
		Line line1 = new Line(p1, p2);
		Line line2 = new Line(p2, p3);
		Line line3 = new Line(p3, p1);
		Triangle t1 = new Triangle(p1, p2, p3);
		assertEquals(2, t1.getLine1().getPoint1().getX(), 0);
		assertEquals(1, t1.getLine2().getPoint2().getY(), 0);
		/*
		 * 
		 * //Triangle via Triangle 1st constructor, line 1st constructor and
		 * point. Passing x 1,2,3 and y 1,2,3 Triangle t3 = new Triangle(2, 3,
		 * 1, 1, 3, 1); assertSame(l1, t3.getLine1()); assertSame(l2,
		 * t3.getLine2()); assertSame(l3, t3.getLine3());
		 */}

	@Test
	public void testInvalidConstruction() throws Exception {
		Line l1 = new Line(2, 3, 1, 1);
		Line l2 = new Line(1, 1, 3, 1);
		Line l3 = new Line(3, 1, 2, 3);

		try {
			new Triangle(null, l2, l3);
			fail("Expected exception not thrown for when the first parameter is null");
		} catch (ShapeException e) {
			assertEquals("Invalid Line", e.getMessage());
		}

		try {
			new Triangle(l1, null, l3);
			fail("Expected exception not thrown for when the second parameter is null");
		} catch (ShapeException e) {
			assertEquals("Invalid Line", e.getMessage());
		}

		try {
			new Triangle(Double.POSITIVE_INFINITY, 2, 1, 1, 3, 1);
			fail("Expected exception not thrown");
		} catch (Exception e) {
			assertEquals("Invalid x-location", e.getMessage());
		}
		try {
			new Triangle(1, Double.POSITIVE_INFINITY, 1, 1, 3, 1);
			fail("Expected exception not thrown");
		} catch (Exception e) {
			assertEquals("Invalid y-location", e.getMessage());
		}
		try {
			new Triangle(1, 2, Double.POSITIVE_INFINITY, 1, 3, 1);
			fail("Expected exception not thrown");
		} catch (Exception e) {
			assertEquals("Invalid x-location", e.getMessage());
		}
		try {
			new Triangle(1, 2, 1, Double.POSITIVE_INFINITY, 3, 1);
			fail("Expected exception not thrown");
		} catch (Exception e) {
			assertEquals("Invalid y-location", e.getMessage());
		}
		try {
			new Triangle(1, 2, 1, 1, Double.POSITIVE_INFINITY, 1);
			fail("Expected exception not thrown");
		} catch (Exception e) {
			assertEquals("Invalid x-location", e.getMessage());
		}
		try {
			new Triangle(1, 2, 1, 1, 3, Double.POSITIVE_INFINITY);
			fail("Expected exception not thrown");
		} catch (Exception e) {
			assertEquals("Invalid y-location", e.getMessage());
		}

	}

	@Test
	public void testzeroLengthOfEdges() throws ShapeException {

		try {
			new Triangle(0, 0, 0, 0, 3, 3);
			fail("Expected exception not thrown");
		} catch (Exception e) {
			assertEquals("A line must have a length > 0", e.getMessage());
		}

		Point p1 = new Point(0, 0);
		Point p2 = new Point(0, 0);
		Point p3 = new Point(3, 1);
		try {
			new Triangle(p1, p2, p3);
			fail("Expected exception not thrown");
		} catch (Exception e) {
			assertEquals("A line must have a length > 0", e.getMessage());
		}

		try {
			Line l1 = new Line(0, 0, 0, 0);
			Line l2 = new Line(1, 1, 3, 1);
			Line l3 = new Line(3, 1, 2, 3);
			new Triangle(l1, l2, l3);
			fail("Expected exception not thrown");
		} catch (Exception e) {
			assertEquals("A line must have a length > 0", e.getMessage());
		}
	}

	@Test
	public void checkSameLineVertices() throws ShapeException {
		
		//With X and Y
		//All X = 0 
		try {
			new Triangle(0, 1, 0, 2, 0, 3);
			fail("Expected exception not thrown");
		} catch (Exception e) {
			assertEquals("Vertices cannot all be in the same line", e.getMessage());
		}
		
		//All Y = 0
		try {
			new Triangle(1, 0, 2, 0, 3, 0);
			fail("Expected exception not thrown");
		} catch (Exception e) {
			assertEquals("Vertices cannot all be in the same line", e.getMessage());
		}
		
		// With Points
		//All X = 0 
		try {
			Point p1 = new Point(0, 1);
			Point p2 = new Point(0, 2);
			Point p3 = new Point(0, 3);
			new Triangle(p1,p2,p3);
			fail("Expected exception not thrown");
		} catch (Exception e) {
			assertEquals("Vertices cannot all be in the same line", e.getMessage());
		}

		//All Y = 0
		try {
			Point p1 = new Point(1,0);
			Point p2 = new Point(2,0);
			Point p3 = new Point(3,0);
			new Triangle(p1,p2,p3);
			fail("Expected exception not thrown");
		} catch (Exception e) {
			assertEquals("Vertices cannot all be in the same line", e.getMessage());
		}
		
		// With lines
		//All X = 0 
		try {
			Line l1 = new Line(0, 1, 0, 2);
			Line l2 = new Line(0, 2, 0, 3);
			Line l3 = new Line(0, 3, 0, 1);
			new Triangle(l1,l2,l3);
			fail("Expected exception not thrown");
		} catch (Exception e) {
			assertEquals("Vertices cannot all be in the same line", e.getMessage());
		}
		
		//All Y = 0
		try {
			Line l1 = new Line(1, 0, 2, 0);
			Line l2 = new Line(2, 0, 3, 0);
			Line l3 = new Line(3, 0, 1, 0);
			new Triangle(l1,l2,l3);
			fail("Expected exception not thrown");
		} catch (Exception e) {
			assertEquals("Vertices cannot all be in the same line", e.getMessage());
		}
		
	}

	//Need to find invalid triangle
	@Test
	public void checkValidTraingle() throws ShapeException {
		try {
			new Triangle(1, 1, 2, 1, 3, 3);
		//	fail("Expected exception not thrown");
		} catch (Exception e) {
			assertEquals("Length of an edge cannot be greater than the sum of other two edges", e.getMessage());
		}
	}

	@Test
	public void testComputeArea() throws ShapeException {

		Triangle t1 = new Triangle(2, 3, 1, 1, 3, 1);
		assertEquals(2,  t1.computeArea(), 0);
		
		Point p1 = new Point(2,3);
		Point p2 = new Point(1,1);
		Point p3 = new Point(3,1);
		t1 = new Triangle(p1,p2,p3);
		assertEquals(2,  t1.computeArea(), 0);
		
		Line l1 = new Line(2, 3, 1, 1);
		Line l2 = new Line(1, 1, 3, 1);
		Line l3 = new Line(3, 1, 2, 3);
		t1 = new Triangle(l1, l2, l3);
		assertEquals(2, t1.computeArea(), 0);
		
		
		
		
	}
}
