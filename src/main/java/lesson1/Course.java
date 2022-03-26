package lesson1;

public class Course {

    Obstacle[]obstacles = {new Cross(20), new Wall(7), new Pool(15)};

    public Course() {
        this.obstacles = obstacles;
    }

    public void obstaclesInfo() {
        System.out.println("Length cross: " + ((Cross) obstacles[0]).getLength());
        System.out.println("Height wall: " + ((Wall) obstacles[1]).getHeight());
        System.out.println("Length pool: " + ((Pool) obstacles[2]).getLength());
        System.out.println();
    }

    public boolean passing(Animal animal){
        for (Obstacle obstacle : obstacles){
            if (!obstacle.doIt(animal)) return false;
        }
        return true;
    }

}
