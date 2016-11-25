package troywang.gringotts.biz.processor;

import org.springframework.batch.item.ItemProcessor;

import troywang.gringotts.model.Bill;
import troywang.gringotts.model.User;

/**
 * Created by wangzhijian02 on 2016/11/25.
 */
public class AccountingProcessor implements ItemProcessor<User, Bill> {

    public Bill process(User user) throws Exception {
        System.out.println("start accounting processor.......");
        Bill b = new Bill();
        b.setUser(user);
        b.setFees(70.00);
        b.setPaidFees(0.0);
        b.setUnpaidFees(70.00);
        b.setPayStatus(0);/*unpaid*/
        return b;
    }

}
