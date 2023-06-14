package com.wb.tdp.ms.common.utils;

/**
 * 
 * @author HBEG
 *
 * @param <D> - todo
 * @param <T> - todo
 */
public interface DomainObjectMapper<D, T> {
    D toDomain(T object);
    T fromDomain(D object);
}