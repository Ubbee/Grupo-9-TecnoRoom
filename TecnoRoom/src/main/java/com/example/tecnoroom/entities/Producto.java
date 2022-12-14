package com.example.tecnoroom.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "producto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private float precio;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "stock")
    private short stock;

    @Column(name = "descripcion",length = 1000)
    private String descripcion;

    @Column(name = "imagen")
    private String imagen;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;

}
