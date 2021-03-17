package com.mycompany.unicafe;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class KassapaateTest {

    private Kassapaate kassa;
    private Maksukortti kortti;

    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(1000);
    }

    @Test
    public void konstruktoriAsettaaSaldonOikein() {
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void konstruktoriAsettaaMyydytEdullisetOikein() {
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void konstruktoriAsettaaMyydytMaukkaatOikein() {
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void syoEdullisestiKateisellaPalauttaaOikeinOnnistuessa() {
        assertEquals(5, kassa.syoEdullisesti(245));
    }

    @Test
    public void syoEdullisestiKateisellaPalauttaaKaikenJosEpaonnistuu() {
        assertEquals(239, kassa.syoEdullisesti(239));
    }

    @Test
    public void syoEdullisestiKateisellaKasvattaaKassaaOnnistuessa() {
        kassa.syoEdullisesti(240);
        assertEquals(100240, kassa.kassassaRahaa());
    }

    @Test
    public void syoEdullisestiKateisellaEiKasvataKassaaEpaonnistuessa() {
        kassa.syoEdullisesti(239);
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void syoEdullisestiKasvattaaMyytyjaLounaitaOnnistuessa() {
        kassa.syoEdullisesti(241);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void syoEdullisestiEiKasvataMyytyjaLounaitaEpaonnistuessa() {
        kassa.syoEdullisesti(239);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void syoMaukkaastiKateisellaPalauttaaOikeinOnnistuessa() {
        assertEquals(50, kassa.syoMaukkaasti(450));
    }

    @Test
    public void syoMaukkaastiKateisellaPalauttaaKaikenJosEpaonnistuu() {
        assertEquals(399, kassa.syoMaukkaasti(399));
    }

    @Test
    public void syoMaukkaastiKateisellaKasvattaaKassaaOnnistuessa() {
        kassa.syoMaukkaasti(500);
        assertEquals(100400, kassa.kassassaRahaa());
    }

    @Test
    public void syoMaukkaastiKateisellaEiKasvataKassaaEpaonnistuessa() {
        kassa.syoMaukkaasti(399);
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void syoMaukkaastiKasvattaaMyytyjaLounaitaOnnistuessa() {
        kassa.syoMaukkaasti(401);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void syoMaukkaastiEiKasvataMyytyjaLounaitaEpaonnistuessa() {
        kassa.syoMaukkaasti(399);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    //Korttiin liittyvät
    @Test
    public void syoEdullisestiKortillaVeloittaaSummanKortilta() {
        kassa.syoEdullisesti(kortti);
        assertEquals(760, kortti.saldo());
    }
    
    @Test
    public void syoEdullisestiKortillaEiKasvataKassaa() {
        kassa.syoEdullisesti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void syoEdullisestiKortillaEiVeloitaEpaonnistuessa() {
        kortti = new Maksukortti(239);
        assertEquals(239, kortti.saldo());
    }
    
    @Test
    public void syoEdullisestiKortillaPalauttaaTrueOnnistuessa() {
        assertTrue(kassa.syoEdullisesti(kortti));
    }
    
    @Test
    public void syoEdullisestiKortillaPalauttaaFalseEpaonnistuessa() {
        kortti = new Maksukortti(239);
        assertFalse(kassa.syoEdullisesti(kortti));
    }
    
    @Test
    public void syoEdullisestiKortillaKasvattaaLounaitaOnnistuessa() {
        kassa.syoEdullisesti(kortti);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void syoEdullisestiKortillaEiKasvataLounaitaEpaonnistuessa() {
        kortti = new Maksukortti(239);
        kassa.syoEdullisesti(kortti);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void syoMaukkaastiKortillaVeloittaaSummanKortilta() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(600, kortti.saldo());
    }
    
    @Test
    public void syoMaukkaastiKortillaEiKasvataKassaa() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void syoMaukkaastiKortillaEiVeloitaEpaonnistuessa() {
        kortti = new Maksukortti(399);
        kassa.syoMaukkaasti(kortti);
        assertEquals(399, kortti.saldo());
    }
    
    @Test
    public void syoMaukkaastiKortillaPalauttaaTrueOnnistuessa() {
        assertTrue(kassa.syoMaukkaasti(kortti));
    }
    
    @Test
    public void syoMaukkaastiKortillaPalauttaaFalseEpaonnistuessa() {
        kortti = new Maksukortti(399);
        assertFalse(kassa.syoMaukkaasti(kortti));
    }
    
    @Test
    public void syoMaukkaastiKortillaKasvattaaLounaitaOnnistuessa() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void syoMaukkaastiKortillaEiKasvataLounaitaEpaonnistuessa() {
        kortti = new Maksukortti(339);
        kassa.syoMaukkaasti(kortti);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void lataaRahaaKortilleKasvattaaKassaa() {
        kassa.lataaRahaaKortille(kortti, 100);
        assertEquals(100100, kassa.kassassaRahaa());
    }
    
    @Test
    public void lataaRahaaKortilleKasvattaaKortinSaldoa() {
        kassa.lataaRahaaKortille(kortti, 100);
        assertEquals(1100, kortti.saldo());
    }
    
    @Test
    public void negatiivisellaSummallaEiVoiLadataRahaaKortille() {
        kassa.lataaRahaaKortille(kortti, -100);
        assertEquals(1000, kortti.saldo());
    }
    
    
    

}
