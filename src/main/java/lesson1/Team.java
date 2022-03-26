package lesson1;

public class Team {
    private String nameTeam;

    Animal[] teamAnimal = {
            new Cat("Морис", "red", 10, 30, 10, 5),
            new Wolf("Волк", "серый", 6, 50, 22, 20),
            new Dog("Бобик", "black", 3, 40, 5, 15),
            new Turtle("Тартилла", "green", 20, 5, 0, 20)
    };

    public Team(String nameTeam) {
        this.nameTeam = nameTeam;
    }

    public void participantsGiven() {
        System.out.println("Team: " + nameTeam + "\n");
        for(Animal a : teamAnimal) {
            System.out.println(a);
        }
        System.out.println();
    }

    public void passedTheDistance(Course course){
        System.out.println("Team: " + nameTeam + "\n");
        for (Animal a : teamAnimal){
            if (course.passing(a)){
                System.out.println(a + " Успешно прошел дистанцию!");
            } else {
                System.out.println(a + " Не прошел дистанцию.");
            }
        }
        System.out.println();
    }

}
