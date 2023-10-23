package shape;

public class OctagonalPrism extends Shape{

	private double side;
	
	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	public OctagonalPrism(double height, double side){
		super(height);
		this.side = side;
	}

	@Override
	public double getBaseArea() {
		
		return 2 * (1 + Math.sqrt(2)) * Math.pow(side, 2);
	}

	@Override
	public double getVolume() {
		
		return getBaseArea() * getHeight();
	}


	

	

}
