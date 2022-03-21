package lesson1;

public class Main {


    public static void main(String[] args) {

        Team team = new Team("zoo");
        team.participantsGiven();

        Course course = new Course();
        team.passedTheDistance(course);
        course.obstaclesInfo();

    }
}
