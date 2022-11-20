package com.example.tecnoroom.services;

import com.example.tecnoroom.entities.Orden;
import com.example.tecnoroom.entities.Producto;
import com.example.tecnoroom.repositories.BaseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdenServiceImpl extends BaseServiceImpl<Orden,Long> implements OrdenService{



    public OrdenServiceImpl(BaseRepository<Producto, Long> baseRepository) {
        super(baseRepository);
    }



    @Override
    public Orden findByMail(String mail) throws Exception {
        return null;
    }
    public String generarNumeroOrden() {
        int numero=0;
        String numeroConcatenado="";

        List<Orden> ordenes = baseRepository.findAll();

        List<Integer> numeros= new ArrayList<Integer>();

        ordenes.stream().forEach(o -> numeros.add( Integer.parseInt( o.getNumero())));

        if (ordenes.isEmpty()) {
            numero=1;
        }else {
            numero= numeros.stream().max(Integer::compare).get();
            numero++;
        }

        if (numero<10) { //0000001000
            numeroConcatenado="000000000"+String.valueOf(numero);
        }else if(numero<100) {
            numeroConcatenado="00000000"+String.valueOf(numero);
        }else if(numero<1000) {
            numeroConcatenado="0000000"+String.valueOf(numero);
        }else if(numero<10000) {
            numeroConcatenado="0000000"+String.valueOf(numero);
        }else if(numero<100000) {
            numeroConcatenado="000000"+String.valueOf(numero);
        }else if(numero<1000000) {
            numeroConcatenado="00000"+String.valueOf(numero);
        }

        return numeroConcatenado;
    }

}
