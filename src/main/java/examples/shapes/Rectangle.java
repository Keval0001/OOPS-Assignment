/**
 * 
 */
package examples.shapes;

/**
 * @author Keval.Shah
 *
 */
@SuppressWarnings("WeakerAccess")
public class Rectangle {

	private Line line1;
	private Line line2;
	private Line line3;
	private Line line4;

	public Rectangle(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4)
			throws ShapeException {
		line1 = new Line(x1, y1, x2, y2);
		line2 = new Line(x2, y2, x3, y3);
		line3 = new Line(x3, y3, x4, y4);
		line4 = new Line(x4, y4, x1, y1);
		checkAdjacentEdgeAngle();

	}
	
	public Rectangle(Point p1, Point p2, Point p3, Point p4)
			throws ShapeException {
		if (p1 == null || p2 == null || p3 == null || p4 == null)
			throw new ShapeException("Invalid Rectangle");
		
		line1 = new Line(p1,p2);
		line2 = new Line(p2, p3);
		line3 = new Line(p3, p4);
		line4 = new Line(p4, p1);
		checkAdjacentEdgeAngle();

	}
	
	public Rectangle(Line line1, Line line2, Line line3, Line line4)
			throws ShapeException {
		if (line1 == null || line2 == null || line3 == null || line4 == null)
			throw new ShapeException("Invalid Rectangle");
		
		this.line1 = line1;
		this.line2 = line2;
		this.line3 = line3;
		this.line4 = line4;
		checkAdjacentEdgeAngle();

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

	public Line getLine4() {
		return line4;
	}

	public double getPerimeter() {
		double perimeter = line1.computeLength() + line2.computeLength() + line3.computeLength() + line4.computeLength();
		return perimeter;
	}

	public double getHeight() {
		return line1.computeLength();
	}

	public double getWidth() {
		return line2.computeLength();
	}

	public Point[] getVertices() {
		Point[] point = { line1.getPoint1(), line1.getPoint2(), line3.getPoint1(), line3.getPoint2() };
		return point;
	}

	public double getDiagonal1() throws ShapeException {
		double x = new Line(line1.getPoint1(), line3.getPoint1()).computeLength();
		return x;
	}

	public double getDiagonal2() throws ShapeException {
		double x = new Line(line1.getPoint2(), line3.getPoint2()).computeLength();
		return x; 
	}

	public void checkAdjacentEdgeAngle() throws ShapeException {
		/*
		 * Line diagonal1 = new Line(line1.getPoint1().getX(),
		 * line1.getPoint1().getY(), line3.getPoint1().getX(),
		 * line3.getPoint1().getY()); Line diagonal2 = new
		 * Line(line1.getPoint2().getX(), line1.getPoint2().getY(),
		 * line3.getPoint2().getX(), line3.getPoint2().getY()); double x =
		 * diagonal1.computeLength(); double y = diagonal2.computeLength();
		 */

		if (getDiagonal1() != getDiagonal2()) {
			throw new ShapeException("AdjacentEdgeAngle is not 90 degree, So its not a rectangle");
		}
	}

	public void move(double deltaX, double deltaY) throws ShapeException {
		line1.getPoint1().move(deltaX, deltaY);
		line1.getPoint2().move(deltaX, deltaY);
		line3.getPoint1().move(deltaX, deltaY);
		line3.getPoint2().move(deltaX, deltaY);

	}

	public double computeArea() {
		double area = getWidth() * getHeight();
		return area;
	}

}
