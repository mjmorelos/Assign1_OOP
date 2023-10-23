package shape;

public class TriangularPrism extends Shape {

    private double side;
    
    public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	public TriangularPrism(double height, double side){
        super(height);
        this.side = side;
    }

	@Override
	public double getBaseArea() {
		
		return Math.pow(side, 2) * Math.sqrt(3) / 4;
	}

	@Override
	public double getVolume() {
	
		return getBaseArea() * getHeight();
	}

	
}
