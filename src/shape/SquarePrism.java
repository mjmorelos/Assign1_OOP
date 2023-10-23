package shape;

public class SquarePrism extends Shape{
    
    private double side;
    
    public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	public SquarePrism(double height, double side){
        super(height);
        this.side = side;
    }

	@Override
	public double getBaseArea() {
		
		return side * side;
	}

	@Override
	public double getVolume() {
		
		return getBaseArea() * getHeight();
	}
}
