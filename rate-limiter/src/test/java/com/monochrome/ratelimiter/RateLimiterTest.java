package com.monochrome.ratelimiter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author monochrome
 * @date 2022/10/23
 */
class RateLimiterTest {

    private RateLimiter rateLimiter;

    @BeforeEach
    void setUp() {
        rateLimiter = new RateLimiter();
    }

    @Test
    void limit() {
        for (int i = 0; i < 50; i++) {
            boolean limit = rateLimiter.limit("app-1", "/v1/user");
            assertThat(limit).isTrue();
        }
        boolean limit2 = rateLimiter.limit("app-1", "/v1/user");
        assertThat(limit2).isFalse();

    }
}