package processing

import streams.Gender
import streams.Grade
import streams.GradeType
import streams.Student


fun atLeastOneGradeA(student: Student): Boolean {
    return student.grades.any { grade ->
        GradeType.A == grade.type
    }
}


fun getStudentAges(students: List<Student>): List<Int> {
    return students.map { obj ->
        obj.age
    }
}

fun getStudentsWithMinimumAge(students: List<Student>, minAge: Int): List<Student> {
    return students.filter { student ->
        minAge <= student.age
    }
}


// gender == Gender.MALE
// or gender.name == "MALE"
fun countMaleStudents(students: List<Student>): Int {
    return students.count { student ->
        Gender.MALE == student.gender
    }
}


// gender == Gender.FEMALE
// or gender.name == "FEMALE"
fun avgAgeOfFemaleStudent(students: List<Student>): Double {
    return students.filter { student ->
        Gender.FEMALE == student.gender
    }
        .map { obj: Student ->
            obj.age
        }.average()
}

fun getProductOfStudentAges(students: List<Student>): Int {
    return students.map { obj: Student -> obj.age }
        .reduce { firstStudent, secondStudent ->
            firstStudent * secondStudent
        }
}

// ignore F Grades
fun productOfStudentGrades(student: Student): Int {
    return student.grades.filter { grade ->
        GradeType.F != grade.type
    }.map { grade ->
        grade.type.value
    }.reduce { firstStudent, secondStudent ->
        firstStudent * secondStudent
    }
}

// region BONUS

// use maxByOrNull on grades
fun getBestMathGradeFromStudent(student: Student): Grade? {
    TODO()
}

fun getSortedAges(students: List<Student>): List<Int> {
    TODO()
}

// endregion
