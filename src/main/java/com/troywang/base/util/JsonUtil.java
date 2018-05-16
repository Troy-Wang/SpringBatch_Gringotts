package com.troywang.base.util;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by troywang on 2018/5/16.
 */
public class JsonUtil {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    /**
     * convert Json String to Map
     *
     * @param jsonString
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> readJson2Map(String jsonString) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(jsonString, Map.class);
        } catch (JsonParseException e) {
            logger.error("[Json convert] failed, jsonString=[" + jsonString + "]", e);
        } catch (JsonMappingException e) {
            logger.error("[Json convert] failed, jsonString=[" + jsonString + "]", e);
        } catch (IOException e) {
            logger.error("[Json convert] failed, jsonString=[" + jsonString + "]", e);
        }
        return null;
    }
}
