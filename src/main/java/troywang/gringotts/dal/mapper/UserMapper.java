package troywang.gringotts.dal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import troywang.gringotts.model.User;

/**
 * Created by wangzhijian02 on 2016/11/25.
 */
public class UserMapper implements RowMapper {
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getLong("ID"));
        user.setUserName(resultSet.getString("Name"));
        user.setAge(resultSet.getInt("AGE"));
        user.setBalance(resultSet.getDouble("BALANCE"));
        return user;
    }
}
