package io.github.roaker666.ruleengine.api;

@FunctionalInterface
public interface Action {
    void execute(Facts facts);
}

