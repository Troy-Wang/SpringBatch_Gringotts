package com.troywang.biz.batch.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.JobParametersValidator;
import org.springframework.stereotype.Component;

import com.troywang.biz.constants.JobConstants;

/**
 * validate job parameters
 * Created by troywang on 2018/5/15.
 */
@Component
public class JobParamValidator implements JobParametersValidator {

    @Override
    public void validate(JobParameters jobParameters) throws JobParametersInvalidException {
        if (StringUtils.isBlank(jobParameters.getString(JobConstants.JOB_PARAM_DATE))) {
            throw new JobParametersInvalidException("Job执行参数必须含有" + JobConstants.JOB_PARAM_DATE);
        }
    }
}
