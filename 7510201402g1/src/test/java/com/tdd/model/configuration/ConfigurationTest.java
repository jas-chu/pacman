package com.tdd.model.configuration;

import com.tdd.model.configuration.Configuration;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConfigurationTest {

    public ConfigurationTest() {
    }

    @Test
    public void GetHunterTimes() {
        Configuration instance = Configuration.getConfiguration();
        int expResult = 3;
        int result = instance.getHunterTimes().size();
        assertEquals(expResult, result);
    }

    @Test
    public void GetDeadTime() {
        Configuration instance = Configuration.getConfiguration();
        Long expResult = (long) 1000;
        Long result = instance.getDeadTime();
        assertEquals(expResult, result);
    }

    @Test
    public void PreyTime() {        
        Configuration instance = Configuration.getConfiguration();
        Long expResult = (long) 1000;
        Long result = instance.getPreyTime();
        assertEquals(expResult, result);
    }

}
