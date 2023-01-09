package kr.codesquad.generator.condition;

import kr.codesquad.enums.ErrorMessage;

import java.util.Map;

public class ConditionGeneratorProvider {

    private static final Map<Class, ConditionGenerator> conditions = Map.of(
            SystemConditionGenerator.class, new SystemConditionGenerator()
    );

    public ConditionGenerator get(Class className) {
        ConditionGenerator conditionGenerator = conditions.get(className);
        if (conditionGenerator != null) {
            return conditionGenerator;
        }

        throw new IllegalArgumentException(ErrorMessage.CONDITION_GENERATOR_NOT_FOUND.getMessage());
    }
}
