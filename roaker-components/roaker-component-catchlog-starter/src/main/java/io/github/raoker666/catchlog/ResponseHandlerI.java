package io.github.raoker666.catchlog;

public interface ResponseHandlerI {
    public Object handle(Class returnType, String errCode, String errMsg);
}
