package ru.inbox.savinov_vu.conditional.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;



public class PropertyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String property = context.getEnvironment().getProperty("say");
        return "propertyConditional".equalsIgnoreCase(property);
    }
}
