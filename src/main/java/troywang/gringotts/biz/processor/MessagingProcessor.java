package troywang.gringotts.biz.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.util.StringUtils;

import troywang.gringotts.model.Message;
import troywang.gringotts.model.User;

/**
 * Created by wangzhijian02 on 2016/11/25.
 */
public class MessagingProcessor implements ItemProcessor<User, Message> {

    public Message process(User user) throws Exception {
        System.out.println("start message processor.......");
        if (!StringUtils.hasText(user.getUserName())) {
            throw new RuntimeException("The user name is required!");
        }
        Message m = new Message();
        m.setUser(user);
        m.setContent("Hello " + user.getUserName()
                + ",please pay promptly at end of this month.");
        return m;
    }

}
