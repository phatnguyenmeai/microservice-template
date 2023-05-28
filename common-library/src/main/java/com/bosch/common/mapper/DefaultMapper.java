package com.bosch.common.mapper;

import java.util.List;
import java.util.Set;

public interface DefaultMapper<E, D> {
    /**
     * Convert entity to dto
     *
     * @param entity
     * @return
     */
    D toDto(E entity);

    /**
     * Convert dto to entity
     *
     * @param dto
     * @return
     */
    E toEntity(D dto);

    /**
     * Convert entities to dtos
     *
     * @param entities
     * @return
     */
    Set<D> toDto(Set<E> entities);

    /**
     * Convert dtos to entities
     *
     * @param dtos
     * @return
     */
    Set<E> toEntity(Set<D> dtos);

    /**
     * Convert entities to dtos
     *
     * @param entities
     * @return
     */
    List<D> toDto(List<E> entities);

    /**
     * Convert dtos to entities
     *
     * @param dtos
     * @return
     */
    List<E> toEntity(List<D> dtos);

}
