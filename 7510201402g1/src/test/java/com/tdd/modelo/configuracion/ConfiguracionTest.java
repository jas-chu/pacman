package com.tdd.modelo.configuracion;

import com.tdd.modelo.configuracion.Configuracion;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConfiguracionTest {

    public ConfiguracionTest() {
    }

    @Test
    public void GetTiemposCazador() {
        Configuracion instance = Configuracion.getConfiguracion();
        int expResult = 3;
        int result = instance.getTiemposCazador().size();
        assertEquals(expResult, result);
    }

    @Test
    public void GetTiempoMuerto() {
        Configuracion instance = Configuracion.getConfiguracion();
        Long expResult = (long) 1000;
        Long result = instance.getTiempoMuerto();
        assertEquals(expResult, result);
    }

    @Test
    public void TiempoPresa() {        
        Configuracion instance = Configuracion.getConfiguracion();
        Long expResult = (long) 1000;
        Long result = instance.getTiempoPresa();
        assertEquals(expResult, result);
    }

}
