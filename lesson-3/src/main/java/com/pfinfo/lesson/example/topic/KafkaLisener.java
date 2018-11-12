package com.pfinfo.lesson.example.topic;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 仿写的kafka监听
 * @author pys1714
 *
 */
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repeatable(KafkaLiseners.class)
public @interface KafkaLisener {

	String id() default "";
	
	String containerFactory() default "";
	
	String[] topics() default {};
	
	String topicPattern() default "";
	
	String group() default "";
}
