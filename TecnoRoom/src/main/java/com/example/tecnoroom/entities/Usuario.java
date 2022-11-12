package com.example.tecnoroom.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "dni",nullable = false,unique = true)
    private int dni;

    @Column(name = "admin")
    private boolean esAdmin = false;

    @Transient
    private String password;

    @Column(name = "mail")
    private String mail;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "provincia")
    private String provincia;

    @OneToMany(mappedBy = "usuario")
    private List<Producto> productos = new ArrayList<Producto>();

    @OneToMany(mappedBy = "usuario")
    private List<Orden> ordenesCliente = new ArrayList<Orden>();

}
