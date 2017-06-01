package io.tracking.repository;


import io.tracking.entity.Readings;
import io.tracking.entity.tiress;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class ReadingsRepositoryImpl implements ReadingsRepository {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Readings> findAll() {
        TypedQuery<Readings> query = em.createQuery("select reading from Readings reading",Readings.class);
        return query.getResultList();
    }

    @Override
    public Readings findOne(String vin) {
        return em.find(Readings.class,vin);
    }

    @Override
    public Readings create(Readings readings, tiress tires) {
        em.persist(tires);
        em.persist(readings);

        return readings;
    }

    @Override
    public Readings update(Readings readings) {

        return  em.merge(readings);
    }

    @Override
    public void delete(Readings readings) {
        em.remove(readings);

    }
}
