package troywang.gringotts.file.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import troywang.gringotts.model.TransConfirmModel;

/**
 * Created by wangzhijian02 on 2016/11/25.
 */
public class TransConfirmMapper implements FieldSetMapper<TransConfirmModel> {
    public TransConfirmModel mapFieldSet(FieldSet fieldSet) throws BindException {
        TransConfirmModel transConfirmModel = new TransConfirmModel();
        transConfirmModel.setUserId(fieldSet.readLong(0));
        transConfirmModel.setTransId(fieldSet.readString(1));
        transConfirmModel.setAmount(fieldSet.readDouble(2));
        transConfirmModel.setConfirmTime(fieldSet.readString(3));
        return transConfirmModel;
    }
}
