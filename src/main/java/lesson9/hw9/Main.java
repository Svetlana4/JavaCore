package lesson9.hw9;

//import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Course math = new Course("Math");
        Course phys = new Course("Physics");
        Course geom = new Course("Geometry");
        Course bio = new Course("Biolodgy");
        Course art = new Course("Art");

        List<Student> students = Arrays.asList(
                new Student("Oleg", Arrays.asList(math, geom, phys, bio)),
                new Student("Maria", Arrays.asList(bio, geom)),
                new Student("Anton", Arrays.asList(math, phys, geom)),
                new Student("Maxim", Arrays.asList(geom)),
                new Student("Anna", Arrays.asList())
        );

        List<Student> sortedList = getStudentSorted(students);

        sortedList.forEach(System.out::println);

        List<Course> distinctCourses = getDistinctCourses(students);
        System.out.println(distinctCourses);

        System.out.println(filterStudents(students, math).stream().map(Student::getName).collect(Collectors.toList()));
    }

    private static List<Student> getStudentSorted(List<Student> students) {
        return students.stream()
                .sorted(Comparator.<Student>comparingInt(student -> student.getAllCourses().size()).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }


    private static List<Course> getDistinctCourses(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getAllCourses().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    private static List<Student> filterStudents(List<Student> students, Course course){
        return students.stream()
                .filter(student -> {
                    List<Course> allCourses = student.getAllCourses();
                    return allCourses.contains(course);
                })
                .collect(Collectors.toList());
    }


}
