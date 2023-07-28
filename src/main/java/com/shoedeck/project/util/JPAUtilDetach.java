package com.shoedeck.project.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class JPAUtilDetach {

    @PersistenceContext
    private EntityManager entityManager;

    public void detachEntity(Object entity){
        if(entity != null) entityManager.detach(entity);
    }
}
