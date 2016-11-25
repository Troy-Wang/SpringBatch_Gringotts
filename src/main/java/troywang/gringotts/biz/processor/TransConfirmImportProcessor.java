package troywang.gringotts.biz.processor;

import org.springframework.batch.item.ItemProcessor;

import troywang.gringotts.model.TransConfirmModel;

/**
 * Created by wangzhijian02 on 2016/11/25.
 */
public class TransConfirmImportProcessor implements ItemProcessor<TransConfirmModel, Object> {

    public Object process(TransConfirmModel transConfirmModel) throws Exception {
        System.out.println("每条明细插入对账库, transId=" + transConfirmModel.getTransId());
        return null;
    }

}
