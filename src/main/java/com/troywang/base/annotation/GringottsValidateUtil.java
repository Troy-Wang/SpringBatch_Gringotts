package com.troywang.base.annotation;

import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;

import com.troywang.base.exception.GringottsValidatorException;

/**
 * Created by troywang on 2018/5/14.
 */
public class GringottsValidateUtil {

    public static void validate(Object obj) throws Exception {

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            validate(field, obj);
            field.setAccessible(false);
        }
    }

    public static void validate(Field field, Object obj) throws Exception {

        GringottsValidator gv = field.getAnnotation(GringottsValidator.class);
        Object value = field.get(obj);
        if (gv == null) {
            return;
        }
        String desc = StringUtils.isBlank(gv.desc()) ? field.getName() : gv.desc();

        // check blankable
        if (!gv.blankable()) {
            if ((value == null) || StringUtils.isBlank(value.toString())) {
                throw new GringottsValidatorException(desc + "不能为空");
            }
        }

        // check regex
        if (!gv.regex().equals("")) {
            if (!value.toString().matches(gv.regex())) {
                throw new GringottsValidatorException(desc + "格式不正确");
            }
        }
    }
}
