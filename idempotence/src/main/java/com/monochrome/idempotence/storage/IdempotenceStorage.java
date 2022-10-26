package com.monochrome.idempotence.storage;

/**
 * @author monochrome
 * @date 2022/10/26
 */
public interface IdempotenceStorage {

    boolean saveIfAbsent(String idempotenceId);

    void delete(String idempotenceId);

}
