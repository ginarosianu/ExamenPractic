package Repository;

import Domain.Entity;

import java.util.List;

public interface IRepository <T extends Entity > {
    /**
     * returns an entity by id
     *
     * @param id
     * @return an entity;
     */
    T getById(String id);

    /**
     * adds a movie
     *
     * @param entity
     */
    void insert(T entity);

    /**
     *
     * @return a list containing all entities;
     */
    List<T> getAll();
}