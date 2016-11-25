package troywang.gringotts.biz.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

/**
 * Created by wangzhijian02 on 2016/11/25.
 */
public class EmptyWriter implements ItemWriter<Object> {

    public void write(List<? extends Object> list) throws Exception {
        System.out.println("Default Empty Writer");
    }

}
