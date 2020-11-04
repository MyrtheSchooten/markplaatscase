package dao;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;

public abstract class Dao<T> {
    protected final EntityManager entityManager;

    public Dao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public T get(long id) {
        return entityManager.find(T(), id);
    }

    public T getDetached(long id) {
        T t = entityManager.find(T(), id);
        entityManager.detach(t);
        return t;
    }

    public void save(T e){
        entityManager.getTransaction().begin();
        entityManager.persist(e);
        entityManager.getTransaction().commit();
    }

    public void saveAndDetach(T e) {
        entityManager.getTransaction().begin();
        entityManager.persist(e);
        detach();
        entityManager.getTransaction().commit();
    }

    private void detach() {
        entityManager.flush();
        entityManager.clear();
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


    @SuppressWarnings("unchecked")
    private Class<T> T() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
