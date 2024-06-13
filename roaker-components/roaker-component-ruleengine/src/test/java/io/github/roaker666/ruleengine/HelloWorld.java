package io.github.roaker666.ruleengine;

import io.github.roaker666.ruleengine.api.Rule;
import io.github.roaker666.ruleengine.api.RuleEngine;
import io.github.roaker666.ruleengine.core.DefaultRuleEngine;
import io.github.roaker666.ruleengine.core.RuleBuilder;

public class HelloWorld {
    public static void main(String[] args) {
        RuleEngine ruleEngine = new DefaultRuleEngine();
        Rule rule = new RuleBuilder()
                .name("hello world rule")
                .description("always say hello world")
                .priority(1)
                .when(facts -> true)
                .then(facts -> System.out.println("hello world"))
                .build();

        ruleEngine.fire(rule, null);
    }
}
