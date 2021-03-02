package lab05;

public class StudentRecord {

    private String studentID;
    private float midterm;
    private float assignments;
    private float finalExam;
    private float finalMark;
    private char letterGrade;

    public  StudentRecord(String sID, float a, float m, float e){
        this.studentID = sID;
        this.assignments = a;
        this.midterm = m;
        this.finalExam =e;
        this.finalMark = ((m*0.3f) + (a*0.2f) + (e*0.5f));
        if (finalMark>=80){
            this.letterGrade = 'A';
        }
        else if (finalMark<80 && finalMark>=70){
            this.letterGrade = 'B';
        }
        else if (finalMark<70 && finalMark>=60){
            this.letterGrade = 'C';
        }
        else if (finalMark<60 && finalMark>=50){
            this.letterGrade = 'D';
        }
        else if (finalMark<50){
            this.letterGrade = 'F';
        }
    }

    public String getStudentID(){
        return this.studentID;
    }
    public float getAssignments(){
        return this.assignments;
    }
    public float getMidterm(){
        return this.midterm;
    }
    public float getFinalExam(){
        return this.finalExam;
    }
    public float getFinalMark(){
        return this.finalMark;
    }
    public char getLetterGrade(){
        return this.letterGrade;
    }


}
