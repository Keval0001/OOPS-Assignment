/**
 * 
 */
package examples.shapes;

/**
 * @author Keval.Shah
 *
 */
@SuppressWarnings("WeakerAccess")
public class Ellipse {
	private Point ellipsePoint;
	
	private double a;
	private double b;	
	private double x;
	private double y;
	private double c1;
	private double c2;
	
	
/*	(x - c₁)² / a² + (y - c₂)² / b² = 1

			where:

			(x, y) are the variables - the coordinates of an arbitrary point on the ellipse;
			(c₁, c₂) are the coordinates of the ellipse's center;
			a is the distance between the center and the ellipse's vertex, lying on the horizontal axis;
			b is the distance between the center and the ellipse's vertex, lying on the vertical axis.
*/
//using this one
	public Ellipse(double a, double b, double  x, double y ,double c1, double c2) throws ShapeException{
		Validator.validatePositiveDouble(a, "Invalid major");
		Validator.validatePositiveDouble(b, "Invalid minor");
		ellipsePoint = new Point(x,y);
		this.a=a;
		this.b=b;
		this.c1=c1;
		this.c2=c2;
		
		
	}

	public Ellipse(double a,double b, Point ellipsePoint) throws ShapeException{
		Validator.validatePositiveDouble(a, "Invalid major");
		Validator.validatePositiveDouble(b, "Invalid minor");
		this.ellipsePoint = ellipsePoint;
		this.a=a;
		this.b=b;
	}
	
/*	public Ellipse(double a, double b, Point foci1, Point foci2) throws ShapeException{
		Validator.validatePositiveDouble(a, "Invalid major");
		Validator.validatePositiveDouble(b, "Invalid minor");
		this.ellipsePoint = ellipsePoint;
		this.a=a;
		this.b=b;
	}*/
	
	public Point getEllipsePoint(){return ellipsePoint;}
	public double getMajor(){return a;}
	public double getMinor(){return b;}
	
	public double computeCenter(){
		double result = Math.sqrt(x-c1)/Math.sqrt(a) + Math.sqrt(y-c2)/Math.sqrt(b);
		
		return result;
	}
	
	public double computeArea(){
		return Math.PI * a * b;
	}
}
