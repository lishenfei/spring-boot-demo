package com.lsf.demo.spring.boot.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Created by lishenfei on 2016-12-09.
 */
@Component
public class DbCountHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        try {
            long code = 200;
            if (code >= 0) {
                return Health.up().withDetail("count", code).build();
            } else {
                return Health.unknown().withDetail("count", code).build();
            }
        } catch (Exception e) {
            return Health.down(e).build();
        }
    }
}
