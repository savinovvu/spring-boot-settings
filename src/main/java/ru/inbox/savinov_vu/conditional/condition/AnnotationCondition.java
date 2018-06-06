package ru.inbox.savinov_vu.conditional.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;



public class AnnotationCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        MultiValueMap<String, Object> allAnnotationAttributes = metadata
                .getAllAnnotationAttributes(AnnotationConditionSay.class.getName());
        String value = (String) allAnnotationAttributes.get("value").get(0);
        String property = context.getEnvironment().getProperty("say");


        return property.equalsIgnoreCase(value);
    }
}
