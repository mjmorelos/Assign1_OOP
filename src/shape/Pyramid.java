package shape;

public class Pyramid extends Shape {
    
    private double side;
    
	public Pyramid(double height, double side){
        super(height);
        this.side = side;
    }
    
    public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}



	@Override
	public double getBaseArea() {

		return Math.pow(side, 2);
	}

	@Override
	public double getVolume() {
		return getBaseArea() * getHeight() / 3;
	}




}
