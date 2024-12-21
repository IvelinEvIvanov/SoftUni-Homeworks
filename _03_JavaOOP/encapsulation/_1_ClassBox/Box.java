package encapsulation._1_ClassBox;

public class Box {

    private double length;
    private double width;
    private double height;

    private static final String ERROR_MESSAGE = "cannot be zero or negative.";

    public Box(double length, double width, double height) {
	this.setLength(length);
	this.setWidth(width);
	this.setHeight(height);
    }

    private void setLength(double length) {
	if (length == 0 || length < 0) {
	    throw new IllegalArgumentException("Length " + ERROR_MESSAGE);
	} else {
	    this.length = length;
	}

    }

    private void setWidth(double width) {

	if (width == 0 || width < 0) {
	    throw new IllegalArgumentException("Width " + ERROR_MESSAGE);
	} else {
	    this.width = width;
	}

    }

    private void setHeight(double height) {
	if (height == 0 || height < 0) {
	    throw new IllegalArgumentException("Height " + ERROR_MESSAGE);
	} else {
	    this.height = height;
	}
    }

    public double calculateSurfaceArea() {
	return (2 * this.length * this.width) + (2 * this.length * this.height) + (2 * this.width * this.height);
    }

    public double calculateLateralSurfaceArea() {
	return (2 * this.length * this.height) + (2 * this.width * this.height);
    }

    public double calculateVolume() {
	return this.length * this.height * this.width;
    }

}
