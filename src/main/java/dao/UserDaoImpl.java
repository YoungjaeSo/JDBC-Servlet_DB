package dao;
import database.JDBCUtil;
import domain.UserVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    Connection conn = JDBCUtil.getConnection();

String USERLIST_INSERT = "insert into userlist (name, email, age, password) values(?,?,?,?)";
String USERLIST_SELECT = "select * from userlist";
String USER_DELETE = "delete from userlist WHERE id =?";
String USERLIST_UPDATE = "update userlist set name =?, email =?, age =?, password =? where id =?";

@Override
    public int insert(UserVO user){
    int result = 0;
    try(PreparedStatement pstmt = conn.prepareStatement(USERLIST_INSERT)){
        pstmt.setString(1, user.getName());
        pstmt.setString(2, user.getEmail());
        pstmt.setInt(3, user.getAge());
        pstmt.setString(4, user.getPassword());
        result = pstmt.executeUpdate();
    } catch (SQLException e){
        e.printStackTrace();
    }
    return result;
}

@Override
    public List<UserVO> getUserList(){
    List<UserVO> userList = new ArrayList<UserVO>();
    try(PreparedStatement pstmt = conn.prepareStatement(USERLIST_SELECT);
        ResultSet rs = pstmt.executeQuery()){
        while(rs.next()){
            UserVO user = map(rs);
            userList.add(user);
        }
    } catch (SQLException e){
        e.printStackTrace();
    }
    return userList;
}

private UserVO map(ResultSet rs) throws SQLException {
    UserVO user = new UserVO();
    user.setId(rs.getInt("id"));
    user.setName(rs.getString("name"));
    user.setEmail(rs.getString("email"));
    user.setAge(rs.getInt("age"));
    user.setPassword(rs.getString("password"));
    return user;
}

@Override
public int delete(int id){
    int result = 0;
    try(PreparedStatement pstmt = conn.prepareStatement(USER_DELETE)){
        pstmt.setInt(1, id);
        result = pstmt.executeUpdate();
    } catch (SQLException e){
        e.printStackTrace();
    }
    return result;
}

public int update(UserVO user){
    int result = 0;
    try(PreparedStatement pstmt = conn.prepareStatement(USERLIST_UPDATE)){
        pstmt.setString(1, user.getName());
        pstmt.setString(2, user.getEmail());
        pstmt.setInt(3, user.getAge());
        pstmt.setString(4, user.getPassword());
        pstmt.setInt(5, user.getId());
        result = pstmt.executeUpdate();
    } catch (SQLException e){
        e.printStackTrace();
    }
    return result;
}
}
