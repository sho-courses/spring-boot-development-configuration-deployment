package org.nekosoft.pdffer._misc;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@ConditionalOnWebApplication
@RestController
public class CustomLoggingController {

    @GetMapping("loggerName")
    public String getLoggerNameEndpoint() {
        return CustomLoggerConfiguration.class.getCanonicalName();
    }

    @GetMapping("coolLogger")
    public CoolBean getCoolLoggerEndpoint(CoolBean coolBean) {
        return coolBean;
    }

}
