package troywang.gringotts.biz.processor;

import org.springframework.batch.item.ItemProcessor;

import troywang.gringotts.model.Message;
import troywang.gringotts.model.User;

/**
 * Created by wangzhijian02 on 2016/11/25.
 */
public class MessageProcessor implements ItemProcessor<User, Message> {
    public Message process(User user) throws Exception {
        Message m = new Message();
        m.setContent("hello, this is " + user.getUserName() + ", I'm " + user.getAge() + " years old");
        return m;
    }
}
