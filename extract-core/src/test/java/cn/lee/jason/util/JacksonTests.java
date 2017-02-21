package cn.lee.jason.util;

import cn.lee.jason.modules.utils.mapper.JsonMapper;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;

/**
 * Created by jason on 17/2/21.
 */

public class JacksonTests {

    @Test
    public void testMapper() {
       JsonMapper mapper = JsonMapper.nonEmptyMapper();
        Assert.assertNotNull(mapper);
    }

    @Test
    public void testConvert() throws IOException {
        JsonMapper mapper = JsonMapper.nonEmptyMapper();
        Resource resource =  new ClassPathResource("/util/jackson/json/map.json");
        String json = readFileToString(resource.getFile(),"utf-8");
        Map map = mapper.fromJson(json,mapper.buildMapType(HashMap.class,String.class,Map.class));
        Assert.assertNotNull(map);
    }
}
