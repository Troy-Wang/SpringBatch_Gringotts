package troywang.gringotts.biz.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import troywang.gringotts.model.Message;

/**
 * Created by wangzhijian02 on 2016/11/25.
 */
public class MessageWriter implements ItemWriter<Message> {
    public void write(List<? extends Message> list) throws Exception {
        System.out.println("start to send message....");
        for (Message m : list) {
            System.out.println(m.getContent());
        }
    }
}
