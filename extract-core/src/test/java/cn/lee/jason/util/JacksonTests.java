package cn.lee.jason.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jason on 17/2/21.
 */

public class JacksonTests {

    @Test
    public void testMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        Assert.assertNotNull(mapper);
    }
}
