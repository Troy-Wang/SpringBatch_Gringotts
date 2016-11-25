package troywang.gringotts.file.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import troywang.gringotts.model.User;

/**
 * Created by wangzhijian02 on 2016/11/25.
 */
public class UserInfoMapper implements FieldSetMapper<User> {

    public User mapFieldSet(FieldSet fieldSet) throws BindException {
        User user = new User();
        user.setUserName(fieldSet.readString(0));
        user.setAge(fieldSet.readInt(1));
        return user;
    }
}
