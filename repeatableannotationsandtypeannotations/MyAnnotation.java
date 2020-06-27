package repeatableannotationsandtypeannotations;

import java.lang.annotation.*;

@Repeatable(MyAnnotations.class)//指定可重复注解的容器
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE_PARAMETER,ElementType.PARAMETER})//后面的是类型注解
public @interface MyAnnotation {
    String value() default "wangyang";
}
