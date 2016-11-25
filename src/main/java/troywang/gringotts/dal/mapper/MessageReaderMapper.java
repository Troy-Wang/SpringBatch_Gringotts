package troywang.gringotts.dal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import troywang.gringotts.model.User;

/**
 * Created by wangzhijian02 on 2016/11/25.
 */
public class MessageReaderMapper implements RowMapper {
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        User u = new User();
        u.setUserId(resultSet.getLong("USER_ID"));
        u.setUserName(resultSet.getString("NAME"));
        u.setBalance(resultSet.getDouble("BALANCE"));
        return u;
    }
}
