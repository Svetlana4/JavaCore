package lesson1;

public class Pool implements Obstacle{

    private int length;

    public Pool(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public boolean doIt(Animal animal) {
        return animal.swim(length);
    }


}
