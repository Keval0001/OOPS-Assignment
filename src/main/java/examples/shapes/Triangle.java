/**
 * 
 */
package examples.shapes;

/**
 * @author Keval.Shah
 *
 *         Triangle
 */

@SuppressWarnings("WeakerAccess")
public class Triangle {

	private Line line1;
	private Line line2;
	private Line line3;

	public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) throws ShapeException {

		line1 = new Line(x1, y1, x2, y2);
		line2 = new Line(x2, y2, x3, y3);
		line3 = new Line(x3, y3, x1, y1);

		// checkZeroLengthOfEdges();
		checkSameLineVertices();
		checkValidTraingle();
	}

	public Triangle(Point point1, Point point2, Point point3) throws ShapeException {
		if (point1 == null || point2 == null || point3 == null)
			throw new ShapeException("Invalid Point");

		this.line1 = new Line(point1, point2);
		this.line2 = new Line(point2, point3);
		this.line3 = new Line(point3, point1);

		checkSameLineVertices();
		checkValidTraingle();

	}

	public Triangle(Line line1, Line line2, Line line3) throws ShapeException {

		if (line1 == null || line2 == null || line3 == null) {
			throw new ShapeException("Invalid Line");
		}

		this.line1 = line1;
		this.line2 = line2;
		this.line3 = line3;

		checkSameLineVertices();
		checkValidTraingle();

	}

	public Line getLine1() {
		return line1;
	}

	public Line getLine2() {
		return line2;
	}

	public Line getLine3() {
		return line3;
	}

	public void move(double deltaX, double deltaY) throws ShapeException {
		line1.move(deltaX, deltaY);
		line2.move(deltaX, deltaY);
		line3.move(deltaX, deltaY);
	}

	// NOT NEEDED ALREADY BEENCHECKED IN LIN CREATION
	/*
	 * // no edges of triangle should have zero length public void
	 * checkZeroLengthOfEdges() throws ShapeException {
	 * 
	 * if (line1.computeLength() < 0.00000001 || line2.computeLength() <
	 * 0.00000001 || line3.computeLength() < 0.00000001) { throw new
	 * ShapeException("Edges must have a length > 0"); } }
	 */

	// Vertices cannot all be in a same line
	public void checkSameLineVertices() throws ShapeException {

		if (line1.getPoint1().getX() == line2.getPoint1().getX() && line2.getPoint1().getX() == line3.getPoint1().getX()
				|| line1.getPoint1().getY() == line2.getPoint1().getY()
						&& line2.getPoint1().getY() == line3.getPoint1().getY()) {
			throw new ShapeException("Vertices cannot all be in the same line");
		}
	}

	// Length of an edge cannot be greater than the sum of other two edges
	public void checkValidTraingle() throws ShapeException {

		if (line1.computeLength() > line2.computeLength() + line3.computeLength()
				|| line3.computeLength() > line1.computeLength() + line2.computeLength()
				|| line2.computeLength() > line3.computeLength() + line1.computeLength()) {
			throw new ShapeException("Length of an edge cannot be greater than the sum of other two edges");
		}
	}

	// Area of triangle using Heron's formula
	public double computeArea() {
		double s = (line1.computeLength() + line2.computeLength() + line3.computeLength()) / 2;
		double result = Math
				.sqrt(s * (s - line1.computeLength()) * (s - line2.computeLength() * (s - line3.computeLength())));
		return result;
	}

}
