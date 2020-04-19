import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.*;


public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";
    private static MysqlDataSource DATASOURCE=new MysqlDataSource();
    static {
        DATASOURCE.setUrl(URL);
        DATASOURCE.setUser(USER_NAME);
        DATASOURCE.setPassword(PASSWORD);
    }
    /**
     * 封装一个返回值为Connction的方法 来获取数据库的连接
     * 1.class.format("com.mysql.jdbc.Driver")
     * DriverManager.getConnction();
     *
     * 2.DataSource;
     */
    public static Connection getConnection(){
        MysqlDataSource dataSource=new MysqlDataSource();
        dataSource.setUrl(URL);
        dataSource.setUser(USER_NAME);
        dataSource.setPassword(PASSWORD);
        try{
            return dataSource.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("数据库连接失败");
        }
    }

    /**
     *
     * @param connection 数据库连接
     * @param ps  数据库操作对象
     * @param rs 操作结果集
     */
    public static void close(Connection connection,PreparedStatement ps,ResultSet rs){
        try{
            if(rs!=null){
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            if(connection!=null){
                connection.close();
            }
        }catch (SQLException e){
            throw new RuntimeException("释放数据库资源错误");
        }
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
    /*
    private static DataSource DATASOURCE=new MysqlDataSource();
    static {
        ((MysqlDataSource)DATASOURCE).setUrl(URL);
        ((MysqlDataSource)DATASOURCE).setUser(USER_NAME);
        ((MysqlDataSource)DATASOURCE).setPassword(PASSWORD);
    }
    public static Connection getConnection{
        try{
            return DATASOURCE.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("数据库连接失败");
        }
    }
    public static void main(String[] args){
        try{
            Connection connection=DATASOURCE.getConnection();
            System.out.println(connection);
        }catch ()
    }
    //1.加载驱动
    //2.建立连接
    //3.创建执行对象
    //4.执行sql
    //5.处理结果集
    //释放资源
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
         connection= DriverManager
                 .getConnection(URL,USER_NAME,PASSWORD);
         System.out.println(connection);
           statement=connection.createStatement();
            String sql="select *from Student";
          resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                Integer id=resultSet.getInt(1);
                Integer sn=resultSet.getInt(2);
                String name=resultSet.getString(3);
                String qq=resultSet.getString(4);
                Integer classesId=resultSet.getInt(5);
                System.out.println(String.format("id=%s,sn=%s"+
                        "name=%s,qq=%s,classesId=%s",id,sn,name,qq,classesId));
            }
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(resultSet!=null) {
                    resultSet.close();
                }
                if(statement!=null) {
                    statement.close();
                }
                if(connection!=null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
*/