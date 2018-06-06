package ru.inbox.savinov_vu.conditional.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import ru.inbox.savinov_vu.utils.HelloSayer;



public class DefaultCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return context.getBeanFactory().getBeansOfType(HelloSayer.class).isEmpty();
    }
}
