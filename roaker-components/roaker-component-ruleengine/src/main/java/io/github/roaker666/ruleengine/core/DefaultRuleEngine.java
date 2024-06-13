package io.github.roaker666.ruleengine.core;

import io.github.roaker666.ruleengine.api.Facts;
import io.github.roaker666.ruleengine.api.Rule;
import io.github.roaker666.ruleengine.api.RuleEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultRuleEngine implements RuleEngine {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultRuleEngine.class);

    @Override
    public void fire(Rule rule, Facts facts) {
        if (rule == null) {
            LOGGER.error("Rules is null! Nothing to apply");
            return;
        }
        rule.apply(facts);
    }
}
