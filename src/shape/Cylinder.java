package shape;

public class Cylinder extends Shape{
	
	private double radius;

	public Cylinder(double height, double radius) {
		super(height);
		this.radius = radius;
		// TODO Auto-generated constructor stub
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getBaseArea() {
		// TODO Auto-generated method stub
		return Math.PI * Math.pow(radius,  2);
	}
	
	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return getBaseArea() * getHeight();
	}

}
