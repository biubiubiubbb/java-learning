package base.reflection.annotation.simple;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 *形式：
 * 元注解
 * public @注解名{}
 *
 * 元注解：
 * @Target:描述注解能够作用的位置(类ElementType.TYPE/方法ElementType.METHOD/属性ElementType.FIELD)
 * @Retention:描述注解被保留的阶段(RetentionPolicy 源码阶段SOURCE、类对象阶段CLASS、运行时阶段RUNTIME)
 * @Documented:描述注解是否被抽取到api文档中
 * @Inherited:描述注解是否被子类继承
 *本质上为 @interface MyAnnotation extends java.lang.annotation.Annotation
 */
@Target(value = {ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface SimpleAnnotation {
    String className();

    String methodName();
}
