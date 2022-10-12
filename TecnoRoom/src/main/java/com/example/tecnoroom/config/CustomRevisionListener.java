package com.example.tecnoroom.config;

import com.example.tecnoroom.entities.audit.Revision;

import java.io.Serializable;

public class CustomRevisionListener implements Serializable {

    public void newRevision(Object revisionEntity){
        final Revision revision = (Revision) revisionEntity;
    }

}
