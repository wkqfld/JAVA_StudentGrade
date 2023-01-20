package test;

import java.util.ArrayList;

import school.School;
import school.Subject;
import school.Student;
import school.Score;
import school.GenerateGradeReport;
import utils.Define;

public class MainTest {
	
	School goodSchool = School.getInstance();
	Subject korean;
	Subject math;

	public static void main(String[] args) {
		MainTest test = new MainTest();
		
		test.createSubject();
		test.createStudent();
		
		String report = new GenerateGradeReport().getReport();
		System.out.println(report);
	}
	
	public void createSubject() {
		korean = new Subject("국어", Define.KOREAN);
		math = new Subject("수학", Define.MATH);
		
		goodSchool.addSubject(korean);
		goodSchool.addSubject(math);
	}
	
	public void createStudent() {
		Student student1 = new Student(211213, "강감찬", korean);
		Student student2 = new Student(212330, "김유신", math);
		Student student3 = new Student(201518, "신사임당", korean);
		Student student4 = new Student(202360, "이순신", korean);
		Student student5 = new Student(201290, "홍길동", math);
		
		goodSchool.addStudent(student1);
		goodSchool.addStudent(student2);
		goodSchool.addStudent(student3);
		goodSchool.addStudent(student4);
		goodSchool.addStudent(student5);
		
		korean.register(student1);
		korean.register(student2);
		korean.register(student3);
		korean.register(student4);
		korean.register(student5);
		
		math.register(student1);
		math.register(student2);
		math.register(student3);
		math.register(student4);
		math.register(student5);
		
		addScoreForStudent(student1, korean, 95);
		addScoreForStudent(student1, math, 56);
		
		addScoreForStudent(student2, korean, 95);
		addScoreForStudent(student2, math, 95);
		
		addScoreForStudent(student3, korean, 100);
		addScoreForStudent(student3, math, 88);
		
		addScoreForStudent(student4, korean, 89);
		addScoreForStudent(student4, math, 95);
		
		addScoreForStudent(student5, korean, 85);
		addScoreForStudent(student5, math, 56);
		
	}
	
	public void addScoreForStudent(Student student, Subject subject, int point) {
		Score score = new Score(student.getStudentId(), subject, point);
		student.addSubjectScore(score);
	}

}
