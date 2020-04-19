import java.math.BigDecimal;

public class Score {
    private Integer id;
    private BigDecimal Score;
    private Integer studentId;
    private Integer courseId;
    //课程名称
    private String courseName;
    private String studentName;

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", Score=" + Score +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", studentName='" + studentName + '\'' +
                '}';
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getScore() {
        return Score;
    }

    public void setScore(BigDecimal score) {
        Score = score;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}

