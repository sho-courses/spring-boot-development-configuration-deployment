package org.nekosoft.pdffer.actuator;

import org.nekosoft.pdffer.PdfferProducerBean;
import org.nekosoft.pdffer.mail.PdfferMailerBean;
import org.nekosoft.pdffer.registry.PdfferRegistryBean;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Pdffer health indicator.
 */
@Component
@ConditionalOnClass(name = "org.springframework.boot.actuate.health.HealthIndicator")
@Profile("pdffer-actuator")
public class PdfferHealthIndicator implements HealthIndicator {

    /**
     * The Context.
     */
    ApplicationContext context;

    /**
     * Instantiates a new Pdffer health indicator.
     *
     * @param context the context
     */
    public PdfferHealthIndicator(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public Health health() {
        String[] producer = context.getBeanNamesForType(PdfferProducerBean.class);
        if (producer.length == 1) {
            return Health.up().withDetail("ProducerBean", "OK").build();
        } else if (producer.length == 0) {
            return Health.down().withDetail("ProducerBean", "MISSING").build();
        } else {
            return Health.unknown().withDetail("ProducerBean", "TOO_MANY").build();
        }
    }

}