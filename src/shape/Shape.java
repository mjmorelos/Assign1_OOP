package shape;

import java.util.Comparator;

public abstract class Shape implements Comparable<Shape>, Comparator<Shape> {
	
	private double height;
	
	public Shape(double height) {
		super();
//		this.height = height;
		setHeight(height);
	}

	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public int compareTo(Shape that) {
		if (this.height < that.height) {
			return -1;
		}
		if (this.height > that.height) {
			return 1;
		}
		return 0;
	}

	@Override
	public int compare(Shape firstShape, Shape secondShape) {
		if (firstShape.getVolume() < secondShape.getVolume()) {
			return -1;
		}
		if (firstShape.getVolume() > secondShape.getVolume()) {
			return 1;
		}
		return 0;
	}
	
	public abstract double getVolume();
	public abstract double getBaseArea();

	@Override
	public String toString() {
		return "Shape height: " + getHeight() + ", base area: " + getBaseArea() + ", volume: " + getVolume();
	}
	

}
