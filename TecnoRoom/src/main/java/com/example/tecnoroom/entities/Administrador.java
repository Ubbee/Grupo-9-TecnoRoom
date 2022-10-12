package com.example.tecnoroom.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "administrador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Administrador extends Usuario{

    boolean soyAdmin = true;

}
