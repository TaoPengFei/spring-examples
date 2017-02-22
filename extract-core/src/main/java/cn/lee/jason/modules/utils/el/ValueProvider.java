package cn.lee.jason.modules.utils.el;

/**
 * Created by jason on 17-2-22.
 */

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * 从RecordContent中提取数据,使用springel表达式方式
 *
 * @author jason
 */
public class ValueProvider {

    private ExpressionParser parser;

    public ValueProvider() {
        super();
        this.parser = new SpelExpressionParser();
    }

    public ValueProvider(ExpressionParser parser) {
        this();
        this.parser = parser;
    }

    public void setParser(ExpressionParser parser) {
        this.parser = parser;
    }

    /**
     * 读取指定的expression对应的属性值
     *
     * @param content
     * @param expression
     * @return
     */
    public Object getValue(Object content, String expression) {
        EvaluationContext context = new StandardEvaluationContext(content);
        return parser.parseExpression(expression).getValue(context);
    }

    public <T> T getValue(Object content, String expression, Class<T> clazz) {
        EvaluationContext context = new StandardEvaluationContext(content);
        return parser.parseExpression(expression).getValue(context, clazz);
    }
}
