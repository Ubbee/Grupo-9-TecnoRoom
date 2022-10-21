package com.example.tecnoroom.config;

import com.example.tecnoroom.entities.audit.Revision;

import javax.persistence.Entity;
import java.io.Serializable;


public class CustomRevisionListener implements Serializable {

    public void newRevision(Object revisionEntity){
        final Revision revision = (Revision) revisionEntity;
    }

}
