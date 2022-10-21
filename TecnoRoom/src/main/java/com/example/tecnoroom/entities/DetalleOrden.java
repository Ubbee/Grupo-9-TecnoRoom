package com.example.tecnoroom.entities;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "compras")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class DetalleOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombreProducto")
    private String nombreProducto;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio")
    private double precio;

    @Column(name = "total")
    private double total;

    @Column(name = "fecha")
    private Date fecha;

    @OneToOne(mappedBy = "detalleOrden")
    private Orden orden;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Producto producto;

}
