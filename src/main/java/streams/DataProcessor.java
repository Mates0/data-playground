package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataProcessor {


    public static boolean atLeastOneGradeA(Student student) {
        return student.getGrades().stream().anyMatch(grade -> GradeType.A == grade.getType());
    }


    public static List<Integer> getStudentAges(List<Student> students) {
        return students.stream().map(Student::getAge).toList();
    }

    public static List<Student> getStudentsWithMinimumAge(List<Student> students, int minAge) {
        return students.stream().filter(student -> minAge <= student.getAge()).toList();
    }


    // getGender() == Gender.MALE
    // or getGender().name().equals("MALE")
    public static long countMaleStudents(List<Student> students) {
        return students.stream().filter(student -> Gender.MALE == student.getGender()).count();
    }


    public static double avgAgeOfFemaleStudent(List<Student> students) {
        return students.stream().filter(student -> Gender.FEMALE == student.getGender()).mapToInt(Student::getAge).average().getAsDouble();
    }

    public static Integer getProductOfStudentAges(List<Student> students) {
        return students.stream().map(Student::getAge).reduce(1, (firstStudent, secondStudent) -> firstStudent * secondStudent);
    }

    // ignore F Grades
    public static double productOfStudentGrades(Student student) {
        return student.getGrades().stream().filter(grade -> GradeType.F != grade.getType()).map(grade -> grade.getType().getValue()).reduce(1, (firstStudent, secondStudent) -> firstStudent * secondStudent);
    }

    // region BONUS

    public static Optional<Grade> getBestMathGradeFromStudent(Student student) {
        return Optional.empty();
    }

    public static List<Integer> getSortedAges(List<Student> students) {
        return new ArrayList<>();
    }

    // endregion
}
