package lesson1;

public class Cross implements Obstacle {

    private int length;

    public Cross(int length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public boolean doIt(Animal animal) {
        return animal.run(length);
    }


}
