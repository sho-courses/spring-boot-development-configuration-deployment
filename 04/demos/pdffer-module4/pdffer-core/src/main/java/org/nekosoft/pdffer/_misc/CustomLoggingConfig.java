package org.nekosoft.pdffer._misc;

import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.system.JavaVersion;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnJava(
        range = ConditionalOnJava.Range.EQUAL_OR_NEWER,
        value = JavaVersion.NINE
)
public class CustomLoggingConfig {
    /* ... */
}
