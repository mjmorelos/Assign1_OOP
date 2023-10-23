package shape;

public class Cone extends Shape {
	
	private double radius;
	
	public Cone(double height, double radius) {
		super(height);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getBaseArea() {
		
		return Math.PI * Math.pow(radius, 2);
	}
	
	@Override
	public double getVolume() {
		
		return getBaseArea() * getHeight() / 3;
	}

	@Override
	public String toString()
	{
		return "Cone Shape height: " + getHeight() + " , radius: " + radius + ", base area: " + getBaseArea() + ", volume: " + getVolume();
	}
	
	

}
