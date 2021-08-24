package com.polofox.log;
import java.lang.annotation.*;
@Documented
@Target({ElementType.FIELD,ElementType.LOCAL_VARIABLE,ElementType.PARAMETER,ElementType.CONSTRUCTOR,ElementType.METHOD,ElementType.PACKAGE,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.SOURCE)
@Inherited
public @interface Info {
    String info() default "未声明信息解释";
}
