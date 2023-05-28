package com.bosch.common.service;

import java.util.List;

public interface DefaultService<D, T> {
    /**
     * Save item
     *
     * @param item item with D type
     * @return saved item
     * @throws Exception
     */
    D save(D item) throws Exception;

    /**
     * Save all items
     *
     * @param items
     * @return
     * @throws Exception
     */
    List<D> saveAll(List<D> items) throws Exception;

    /**
     * Update item
     *
     * @param item
     * @return
     * @throws Exception
     */
    D update(D item) throws Exception;

    /**
     * Find item by id
     *
     * @param id
     * @return
     * @throws Exception
     */
    D findById(T id) throws Exception;

    /**
     * Find all items
     *
     * @return
     * @throws Exception
     */
    List<D> findAll() throws Exception;

    /**
     * Delete item by id
     *
     * @param id
     * @throws Exception
     */
    void deleteById(T id) throws Exception;

    /**
     * Delete all items
     *
     * @throws Exception
     */
    void deleteAll() throws Exception;

}
