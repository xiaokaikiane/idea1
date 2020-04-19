import java.util.List;

public class Student {
    private Integer id;
    private Integer sn;
    private String name;
    private String QQMail;
    private Integer classesId;
    private Classes calsses;
    private List<Score> scores;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sn=" + sn +
                ", name='" + name + '\'' +
                ", QQMail='" + QQMail + '\'' +
                ", classesId=" + classesId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQQMail() {
        return QQMail;
    }

    public void setQQMail(String QQMail) {
        this.QQMail = QQMail;
    }

    public Integer getClassesId() {
        return classesId;
    }

    public void setClassesId(Integer classesId) {
        this.classesId = classesId;
    }

    public Classes getCalsses() {
        return calsses;
    }

    public void setCalsses(Classes calsses) {
        this.calsses = calsses;
    }
    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }
}
