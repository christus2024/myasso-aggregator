package fr.it4innov.myasso.association.config.persistance;

import fr.it4innov.myasso.myassoutils.IdGenerator;
import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomIdEntityListener {
    @PrePersist
    public void prePersist(Object entity) {
        if (entity instanceof Identifiable) {
            Identifiable identifiable = (Identifiable) entity;
            if (identifiable.getCustomId() == null) {
                identifiable.setCustomId(IdGenerator.generateId(entity.getClass().getName()));
            }
        }
    }
    @PostPersist
    public void postPersist(Object entity) {
        log.info("entity postPersist: " + entity.getClass().getName());
    }

    @PreUpdate
    public void preUpdate(Object entity) {
        log.info("entity preUpdate: " + entity.getClass().getName());
    }

    @PostUpdate
    public void postUpdate(Object entity) {
        log.info("entity postUpdate: " + entity.getClass().getName());
    }

    @PreRemove
    public void preRemove(Object entity) {
        log.info("entity persisted: " + entity.getClass().getName());
    }

    @PostRemove
    public void postRemove(Object entity) {
        log.info("entity preRemove: " + entity.getClass().getName());
    }

    @PostLoad
    public void postLoad(Object entity) {
        log.info("entity postLoad: " + entity.getClass().getName());
    }

}
