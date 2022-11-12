package com.example.tecnoroom.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orden")
@Getter
@Setter
@Audited
@AllArgsConstructor
@NoArgsConstructor
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fechaCreacion")
    private Date fechaCreacion;

    @Column(name = "total")
    private double total;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_detalleOrden")
    private DetalleOrden detalleOrden;


}
