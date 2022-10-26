package com.monochrome.idempotence;

import com.monochrome.idempotence.storage.IdempotenceStorage;

/**
 * @author monochrome
 * @date 2022/10/26
 */

public class Idempotence {

    IdempotenceStorage idempotenceStorage;

    public Idempotence(IdempotenceStorage idempotenceStorage) {
        this.idempotenceStorage = idempotenceStorage;
    }

    public boolean saveIfAbsent(String idempotenceId) {
        return idempotenceStorage.saveIfAbsent(idempotenceId);
    }

    public void delete(String idempotenceId) {
        idempotenceStorage.delete(idempotenceId);
    }
}