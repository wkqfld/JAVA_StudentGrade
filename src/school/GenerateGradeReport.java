package school;

import java.util.ArrayList;

import grade.BasicEvaluation;
import grade.MajorEvaluation;

public class GenerateGradeReport {
	School school = School.getInstance(); // 왜 이건 private로 선언 안하지?, 
	
	public static final String TITLE = " 수강생 학점 \n";
	public static final String LINE = "--------------------------------- \n";
	public static final String HEADER = " 이름 | 학번 | 중점과목 | 점수 \n";
	
	private StringBuffer buffer = new StringBuffer();
	
	public String getReport() {
		
		ArrayList<Subject> subjectList = school.getSubjectList();
		
		for (Subject subject: subjectList) {
			makeHeader(subject);
			makeBody(subject);
			makeFooter();
		}
		
		
		return buffer.toString();
		
	}
	
	public void makeHeader(Subject subject) {
		buffer.append(GenerateGradeReport.LINE);
		buffer.append(subject.getSubjectName());
		buffer.append(GenerateGradeReport.TITLE);
		buffer.append(GenerateGradeReport.HEADER);
		buffer.append(GenerateGradeReport.LINE);
	}
	
	public String makeBody(Subject subject) {
		
		// 매개변수로 받은 subject를 수강하는 학생리스트
		ArrayList<Student> studentList = subject.getStudentList();
		for (Student student: studentList) {
			int subjectId = subject.getSubjectId();
			String studentName = student.getStudentName();
			int studentId = student.getStudentId();
			buffer.append(" " + studentName);
			buffer.append(" | " + studentId);
			
			getScoreGrade(student, subjectId);
			
			buffer.append("\n");
			buffer.append(LINE);

		}
		
		return buffer.toString();
	}
	
	// 우선 내 방식으로 먼저 돌려보고, 나중에 정답 코드도 따라해보기
	public void getScoreGrade(Student student, int subjectId) {
		
		Subject major = student.getMajor();
		ArrayList<Score> scoreList = student.getScoreList();
		
		for (Score score: scoreList) {
			if (score.getSubject().getSubjectId() == subjectId) {
				String grade;
				
				if (major.getSubjectId() == subjectId) {
					grade = new MajorEvaluation().getGrade(score.getPoint());
				} else {
					grade = new BasicEvaluation().getGrade(score.getPoint());
				}
				
				buffer.append(" | " + major.getSubjectName() + " | " + score.getPoint() + ":" + grade);
			}
		}
	}
	public void makeFooter() {
		buffer.append("\n");
	}
	
	
	
}
