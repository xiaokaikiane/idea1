import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
    public boolean insertStudent(Student student){
        Connection connection=null;
        PreparedStatement ps=null;
        try{
            connection=DBUtil.getConnection();
            String sql="insert into student (id," +
                    "sn,name,qq_mail,classes_id) values" +
                    " (?,?,?,?,?)";
            ps=connection.prepareStatement(sql);
            ps.setInt(1,student.setId());
            ps.setInt(2,student.setSn());
            ps.setString(3,student.setName());
            ps.setString(4,student.setQQMail());
            ps.setInt(5,student.setClassesId());
            int num=ps.executeUpdate();
            return num>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {

        }
    }
}
