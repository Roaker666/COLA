package io.github.roaker666.domain;

/**
 * DomainFactory
 *
 * @author Frank Zhang
 * @date 2019-01-03 2:41 PM
 */
public class DomainFactory {

    public static <T> T create(Class<T> entityClz){
        return ApplicationContextHelper.getBean(entityClz);
    }

}
