package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void konstruktoriAsettaaSaldonOikein() {
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void latausKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(5);
        
        assertEquals(15, kortti.saldo());
    }
    
    @Test
    public void oteRahaaVahentaaSaldoaOikeinJosRahatRiittavat() {
        kortti.otaRahaa(9);
        assertEquals(1, kortti.saldo());
    }
    
    @Test
    public void otaRahaaEiVahennaSaldoaJosRahatEivatRiita() {
        kortti.otaRahaa(11);
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void otaRahaaPalauttaaTrueJosOnnistui() {
        assertTrue(kortti.otaRahaa(9));
    }
    
    @Test
    public void otaRahaaPalauttaaFalseJosEiOnnistu() {
        assertFalse(kortti.otaRahaa(11));
    }
    
    @Test
    public void toStringNayttaaOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
}
