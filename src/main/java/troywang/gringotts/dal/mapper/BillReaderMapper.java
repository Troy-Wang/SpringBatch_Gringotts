package troywang.gringotts.dal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import troywang.gringotts.model.Bill;
import troywang.gringotts.model.User;

/**
 * Created by wangzhijian02 on 2016/11/25.
 */
public class BillReaderMapper implements RowMapper {

    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Bill b = new Bill();
        b.setId(resultSet.getLong("ID"));
        User u = new User();
        u.setUserId(resultSet.getLong("USER_ID"));
        u.setUserName(resultSet.getString("NAME"));
        u.setBalance(resultSet.getDouble("BALANCE"));
        b.setUser(u);
        b.setFees(resultSet.getDouble("FEES"));
        b.setPaidFees(resultSet.getDouble("PAID_FEES"));
        b.setUnpaidFees(resultSet.getDouble("UNPAID_FEES"));
        b.setPayStatus(resultSet.getInt("PAY_STATUS"));
        return b;
    }

}
