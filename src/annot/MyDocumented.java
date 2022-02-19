package annot;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;

//注解都在java.lang.annotation包里
//javadoc -d doc MyDocumented.java

@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@interface MyDocument {
    public String value() default "这是@Documented注解";
}

@MyDocument
public class MyDocumented {
    /**
     * 测试document
     */
    @MyDocument
    public String Test() {
        return "C语言中文网Java教程";
    }
}