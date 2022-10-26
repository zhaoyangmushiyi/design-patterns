package com.monochrome.idempotence;

import java.util.UUID;

/**
 * @author monochrome
 * @date 2022/10/26
 */
public class IdempotenceIdGenerator {
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
