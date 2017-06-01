package io.tracking.repository;

import io.tracking.entity.Vehicles;
import io.tracking.exception.NotFoundException;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository{
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Vehicles> findAll() {
        TypedQuery<Vehicles> query= em.createQuery("select vehicle from Vehicles vehicle",Vehicles.class);
        return query.getResultList();
    }

    @Override
    public Vehicles findOne(String vin) {
        return em.find(Vehicles.class,vin);

    }



    @Override
    public Vehicles create(Vehicles vehicles) {

       em.persist(vehicles);
       return vehicles;
    }

    @Override
    public Vehicles update(Vehicles vehicles) {
       em.merge(vehicles);
     return vehicles;
}

    @Override
    public void delete(Vehicles vehicles) {
         em.remove(vehicles);

    }
}
