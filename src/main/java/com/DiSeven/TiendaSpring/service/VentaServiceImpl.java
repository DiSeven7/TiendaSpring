package com.DiSeven.TiendaSpring.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Random;

@Service
public class VentaServiceImpl implements VentaService {
    @Override
    public String GenerarReferencia() {
        String referencia = "";
        Random rnd = new Random();
        int target = 0;

        var caracteres = new String[]{"B", "C", "D", "F", "H", "J", "K", "L", "M", "N", "P", "R", "S", "T", "V", "W", "X", "Y", "Z"};
        var numeros = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        while (referencia.length() <= 4) {
            target = rnd.nextInt(caracteres.length);
            referencia += caracteres[target];
        }
        while (referencia.length() > 4 && referencia.length() <= 15) {
            target = rnd.nextInt(numeros.length);
            referencia += numeros[target];
        }

        return referencia;
    }
}
