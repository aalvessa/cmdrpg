package com.cmdgames.rpg.repository;

import com.cmdgames.rpg.repository.exception.DataNotFoundException;

import java.io.FileNotFoundException;

public interface Repository {

    public void persist(Persistable persistable);

    public Persistable retrieve() throws FileNotFoundException, DataNotFoundException;

}
