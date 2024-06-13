package io.github.roaker666.unittest.kafka;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target( {ElementType.TYPE, ElementType.METHOD})
public @interface ProduceMessage {

    String value();
}