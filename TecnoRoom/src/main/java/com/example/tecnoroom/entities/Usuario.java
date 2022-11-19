package com.example.tecnoroom.entities;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Audited
@ToString
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

    @Column(name = "rol")
    private String rol;
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns =@JoinColumn(name ="rol_id"))
//    private Set<Rol> roles = new HashSet<>();

    @Column(name = "password")
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

    public void addProducto(Producto producto){
        productos.add(producto);
    }

}
