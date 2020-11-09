package dao;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class Dao<T> {
    protected final EntityManager entityManager;

    public Dao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public T get(long id) {
        return entityManager.find(T(), id);
    }

    public void save(T e){
        entityManager.getTransaction().begin();
        entityManager.persist(e);
        entityManager.getTransaction().commit();
    }

    public T update(T e) {
        entityManager.getTransaction().begin();
        T merged = entityManager.merge(e);
        entityManager.getTransaction().commit();
        return merged;
    }

    public void remove(T e) {
        entityManager.getTransaction().begin();
        entityManager.remove(e);
        entityManager.getTransaction().commit();
    }

    public List<T> findAll() {
        return entityManager.createQuery("SELECT e FROM " + typeSimple() + " e ", T()).getResultList();
    }

    private String typeSimple() { return T().getSimpleName(); }

    @SuppressWarnings("unchecked")
    private Class<T> T() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
