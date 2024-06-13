package io.github.roaker666.ruleengine.api;

public interface RuleEngine {
    /**
     * Fire rule on given facts.
     */
    void fire(Rule rule, Facts facts);

}
