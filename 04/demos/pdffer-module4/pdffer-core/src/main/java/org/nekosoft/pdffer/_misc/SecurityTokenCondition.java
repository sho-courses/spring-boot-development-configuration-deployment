package org.nekosoft.pdffer._misc;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SecurityTokenCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Resource r = context.getResourceLoader().getResource("classpath:sectoken");
        try {
            if (r.exists() && r.isFile() && r.isReadable()) {
                try (Reader d = new InputStreamReader(r.getInputStream())) {
                    return "NEKOPDFFER".equals(FileCopyUtils.copyToString(d));
                }
            }
            return false;
        } catch (IOException e) {
            return false;
        }
    }

}
