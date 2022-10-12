package com.example.tecnoroom.entities;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario{

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_compras")
    List<Compras> compras = new ArrayList<Compras>();

}
