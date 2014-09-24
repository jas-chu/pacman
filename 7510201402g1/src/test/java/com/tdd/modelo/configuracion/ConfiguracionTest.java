package com.tdd.configuracion;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConfiguracionTest {

    public ConfiguracionTest() {
    }

    @Test
    public void testGetTiemposCazador() {
        System.out.println("getTiemposCazador");
        Configuracion instance = Configuracion.getConfiguracion();
        int expResult = 3;
        int result = instance.getTiemposCazador().size();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTiempoMuerto() {
        System.out.println("getTiempoMuerto");
        Configuracion instance = Configuracion.getConfiguracion();
        Long expResult = (long) 1000;
        Long result = instance.getTiempoMuerto();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTiempoPresa() {
        System.out.println("getTiempoPresa");
        Configuracion instance = Configuracion.getConfiguracion();
        Long expResult = (long) 1000;
        Long result = instance.getTiempoPresa();
        assertEquals(expResult, result);
    }

}
