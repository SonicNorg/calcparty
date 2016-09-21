package ru.hbsolutions.partyplanner.dao;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class Dao<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    protected final Class<T> entityClass;

    {
        Type type = this.getClass().getGenericSuperclass();
        try {
            @SuppressWarnings("unchecked")
            Class<T> clazz = (Class<T>)( (type instanceof ParameterizedType) ? ParameterizedType.class.cast(type).getActualTypeArguments()[0] : type );

            entityClass = clazz;
        } catch (ClassCastException ex) {
            throw new RuntimeException(ex);
        }
    }


    public T get(Serializable id) {
        return entityManager.find(entityClass, id);
    }

    public void create(T entity) {
        entityManager.persist(entity);
    }

    public T update(T entity) {
        return entityManager.merge(entity);
    }

    public void remove(T entity) {
        entityManager.remove(entity);
    }

    public List<T> list() {
        return list(new Query());
    }

    public List<T> list(Query query) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> from = cq.from(entityClass);

        processOrders(query.orders, from, cq, cb);

        return entityManager.createQuery(cq).getResultList();
    }

    private CriteriaQuery<T> processOrders(Map<String, OrderType> orders, Root<T> from, CriteriaQuery<T> criteriaQuery, CriteriaBuilder cb) {
        List<Order> orderList = orders
                .entrySet()
                .stream()
                .map(entry -> {
                    Path column = from.get(entry.getKey());
                    OrderType orderType = entry.getValue();

                    return (orderType == OrderType.DESC) ? cb.desc(column) : cb.asc(column);
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return criteriaQuery.orderBy(orderList);
    }
}
