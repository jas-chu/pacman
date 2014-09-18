/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tdd.configuracion;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author agu
 */
public class ConfiguracionTest {
    
    public ConfiguracionTest() {
    }



    /**
     * Test of getTiemposCazador method, of class Configuracion.
     */
    @Test
    public void testGetTiemposCazador() {
        System.out.println("getTiemposCazador");
        Configuracion instance = Configuracion.getConfiguracion();
        int expResult = 3;
        int result = instance.getTiemposCazador().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTiempoMuerto method, of class Configuracion.
     */
    @Test
    public void testGetTiempoMuerto() {
        System.out.println("getTiempoMuerto");
        Configuracion instance = Configuracion.getConfiguracion();
        Long expResult = (long) 1000;
        Long result = instance.getTiempoMuerto();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTiempoPresa method, of class Configuracion.
     */
    @Test
    public void testGetTiempoPresa() {
        System.out.println("getTiempoPresa");
        Configuracion instance = Configuracion.getConfiguracion();
         Long expResult = (long) 1000;
        Long result = instance.getTiempoPresa();
        assertEquals(expResult, result);
    }
    
}
