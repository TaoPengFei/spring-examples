package cn.lee.jason.util;

import cn.lee.jason.modules.utils.mapper.JsonMapper;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;

/**
 * Created by jason on 17/2/21.
 */
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class SpringElTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testSpringEl() throws IOException {
        JsonMapper mapper = JsonMapper.nonEmptyMapper();
        Resource resource = new ClassPathResource("/util/jackson/json/map.json");
        String json = readFileToString(resource.getFile(), "utf-8");
        Map map = mapper.fromJson(json, mapper.buildMapType(HashMap.class, String.class, Map.class));
        Assert.assertNotNull(map);

        ExpressionParser parser = new SpelExpressionParser(new SpelParserConfiguration(true,true));
        EvaluationContext teslaContext = new StandardEvaluationContext(map);
        Object obj = parser.parseExpression("[a][b]").getValue(teslaContext);
        logger.info(obj.toString());

    }
}
