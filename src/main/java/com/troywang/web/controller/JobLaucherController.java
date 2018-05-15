package com.troywang.web.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.troywang.base.enums.GringottsErrorCodeEnum;
import com.troywang.base.model.BaseResponse;

/**
 * Created by troywang on 2018/5/15.
 */
@Controller
public class JobLaucherController extends ApplicationObjectSupport {

    @Autowired
    private JobLauncher jobLauncher;

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(JobLaucherController.class);

    @RequestMapping(value = "jobLauncher", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse launchJob(@RequestParam String jobName, HttpServletRequest request) {
        JobParametersBuilder parametersBuilder = extractParameters(request);
        logger.info("[JobLauncher] launching job, jobName={}, jobParams={}", jobName,
                parametersBuilder.toJobParameters().toString());

        try {
            ApplicationContext applicationContext = super.getApplicationContext();
            Job jobInstance = applicationContext.getBean(jobName, Job.class);
            jobLauncher.run(jobInstance, parametersBuilder.toJobParameters());
        } catch (Exception e) {
            logger.error("[JobLauncher] launch job fail, jobName={}", jobName, e);
            return new BaseResponse(GringottsErrorCodeEnum.JOB_LAUNCH_FAIL.getCode(), e.getMessage());
        }

        return new BaseResponse();
    }

    private JobParametersBuilder extractParameters(HttpServletRequest request) {
        JobParametersBuilder parametersBuilder = new JobParametersBuilder();
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            parametersBuilder.addString(paramName, request.getParameter(paramName));
        }
        return parametersBuilder;
    }
}
