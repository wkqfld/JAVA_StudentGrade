# JAVA_StudentGrade
- 성적관리 프로그램 만들기 : 과목별 수강 학생들의 점수 / 학점 계산하여 리포트 출력

<br>

## Package
  1) grade : 평가방법 관련 클래스 묶음 -> 인터페이스 + 구현클래스
  2) school : 학생, 성적, 과목 클래스 + 이걸 담는 학교 클래스 + 성적표 산출
  3) test: 학교에 성적/학생 리스트 등록 및 리포트 실제 생성 (프론트 역할 겸)
  4) utils : define

<br>

### 1. grade
* getGrade구현 (int point를 매개변수로 받음)
<br>
<image width="40%" src="https://user-images.githubusercontent.com/100992905/213835740-ba133f22-1625-4abd-95bb-18c170e1100b.png" />

<br>

### 2. utils
* Define Class 내에 static final 변수 미리 선언
  - 과목코드
  - 평가 type

<br>

### 3 - 1. school
<br>
<image width="50%" height="50%" src="https://user-images.githubusercontent.com/100992905/213840328-90b027a1-bd54-40f7-9c26-e624ad1d1c74.png" />
<br>

* Score
  - constructor : studentId, subject, point
  - Getter + Setter, toString 
<br>

* Student
  - constructor : studentId, studentName, major
  - scoreList에 점수 추가 by addSubjectScore method
  - Getter + Setter
<br>

* subject
  - constructor : subjectId, subjectName
  - gradeType은 기본적으로 AB_Type으로 설정 후, 나중에 필요시 set으로 변경
  - Getter + Setter
  - register method : studentList에 student 추가
<br>

* school
  - singleton 객체로, 모든 학생과 과목을 관리
  - School instance, SCHOOL_NAME, ArrayList - studentList & subjectList
  - Getter + Setter & addStudent + addSubject

<br>

### 3 - 2. GenerateGradeReport
* School instance 생성
* static final 변수들 : TITLE/HEADER/LINE --> Fomat, 필드명 관련된 요소들 (public)
* Stringbuffer을 사용하여 string을 이어붙임 (private)
<br>

* **getReport()**

  * 학교의 모든 과목에 대한 리포트를 만듦 --> school 객체에서 모든 subjectList 가져오기
  * 각 subject에 대해 Header / Body / Footer 만들기 --> 각각의 method가 있음
  <br>
  
  1) makeHeader(Subject subject)
      - Format 변수 + 과목명 사용
  <br>
  
  2) makeBody (Subject subject)
      - 전체 수강학생 명단 필요
      - 학생별 전공 확인 후, 학점 계산 => getScoreGrade 이용
      - **getScoreGrade** : student 객체 + 과목 Id를 매개변수로 받음
      
        - 평가 방법 가져오기
        - student의 scoreList 가져와서, 1) score의 과목 Id와 매개변수로 받은 과목 Id 비교, 2) major 과목 Id와 비교
   <br>
   
   3) makeFooter
      - All Common
<br>

### 4. TestMain
<br>

    School GoodSchool = School getInstance()
    Subject Korean;
    Subject Math;
<br>

* main 함수
  - TestMain 객체 생성 후 createSubject, createStudent로 리스트 만들기
  - report(String 객체) 생성하여 출력
<br>

* createSubject
  - korean, math 객체 생성 후 school 객체에 add
<br>

* createStudent
  - student 1~5 생성 후 school 객체에 추가
  - 과목 객체에 student 추가 (register)
  - 학생별 scoreList 만들어주기 => addScoreForStudent method 사용

  - **addScoreForStudent**
    - Score객체 생성 후 student 객체에 
