package shape;

public class PentagonalPrism extends Shape {
    
    private double side;
    
    public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	public PentagonalPrism(double height, double side){
        super(height);
        this.side = side;
    }

	@Override
	public double getBaseArea() {
		
		return (5 * Math.pow(side, 2) * Math.tan(54)) / 4;
	}

	@Override
	public double getVolume() {
		
		return getBaseArea() * getHeight();
	}



}
