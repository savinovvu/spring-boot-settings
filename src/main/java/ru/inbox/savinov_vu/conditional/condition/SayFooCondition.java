package ru.inbox.savinov_vu.conditional.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;



public class SayFooCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String sayType = System.getProperty("say");
        return sayType != null && sayType.equalsIgnoreCase("foo");
    }
}
