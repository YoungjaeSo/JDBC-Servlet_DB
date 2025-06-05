package dao;

import domain.UserVO;
import java.util.List;
import java.sql.SQLException;

public interface UserDao {
    int insert(UserVO user)throws SQLException;
    List<UserVO> getUserList() throws SQLException;
    int delete(int id) throws SQLException;
    int update(UserVO user) throws SQLException;
}
