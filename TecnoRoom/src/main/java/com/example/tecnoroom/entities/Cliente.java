package com.example.tecnoroom.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Cliente extends Usuario{


    @OneToMany(mappedBy = "cliente")
    private List<Producto> productos = new ArrayList<Producto>();

    @OneToMany(mappedBy = "cliente")
    private List<Orden> ordenesCliente = new ArrayList<Orden>();
}
