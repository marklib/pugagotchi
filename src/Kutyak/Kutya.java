package Kutyak;
import Eszkozok.Eszkoz;
import Eszkozok.Felhasznalhato.*;
import Eszkozok.Tulajdonsagok;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Kutya {
    private Tulajdonsagok tulajdonsagok;
    private String nev;
    private String tulajdonos;
    private Map<Eszkoz, Integer> eszkoztar;
    private boolean elet;
    private int ehes = 0;
    private int szomoru = 0;
    private int egeszsegtelen = 0;
    private boolean tiszta = true;
    private int koszreteg = 0;

    public boolean isTiszta(){
        return tiszta;
    }

    public boolean getElet(){
        return elet;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getTulajdonos() {
        return tulajdonos;
    }

    public void setTulajdonos(String tulajdonos) {
        this.tulajdonos = tulajdonos;
    }

    public Tulajdonsagok getTulajdonsagok(){
        return tulajdonsagok;
    }

    public Kutya(String nev, String tulajdonos){
        this.nev = nev;
        this.tulajdonos = tulajdonos;
        this.tulajdonsagok = new Tulajdonsagok(62, 62, 62, 62, 62, 1500);
        startEszkoztar();
        this.elet = true;
    }

    //a kutya tulajdonságait módosítja egy eszköz tulajdonságaival
    public void hasznal(Eszkoz eszkoz){
        if(elet){
            this.tulajdonsagok.felhasznal(eszkoz.getTulajdonsagok());
        }
        meghal();
    }

    //hozzáad valamit az eszköztárhoz
    public void vasarol(Felhasznalhato eszkoz){
        for (Eszkoz key : getEszkoztar().keySet()){
            if(key.getClass() == eszkoz.getClass()){
                this.tulajdonsagok.setPenz(getTulajdonsagok().getPenz()+eszkoz.getTulajdonsagok().getPenz()); //pénz levon
                this.eszkoztar.put(key, this.eszkoztar.get(key)+1); //eszköztárhoz ad
                break;
            }
        }
    }

    //eszköztár létrehozása
    private void startEszkoztar(){
        this.eszkoztar = new HashMap<>();
        Csont csont = new Csont();
        csont.megvesz();
        Hazikoszt hazikoszt = new Hazikoszt();
        hazikoszt.megvesz();
        Jutalomfalatka jutalomfalatka = new Jutalomfalatka();
        jutalomfalatka.megvesz();
        KonzervKutyaeledel konzervKutyaeledel = new KonzervKutyaeledel();
        konzervKutyaeledel.megvesz();
        KutyaEnergiaital kutyaEnergiaital = new KutyaEnergiaital();
        kutyaEnergiaital.megvesz();
        MaximalizaloItal maximalizaloItal = new MaximalizaloItal();
        maximalizaloItal.megvesz();
        SzarazKutyatap szarazKutyatap = new SzarazKutyatap();
        szarazKutyatap.megvesz();
        Viz viz = new Viz();
        viz.megvesz();
        this.eszkoztar.put(csont, 0);
        this.eszkoztar.put(hazikoszt, 0);
        this.eszkoztar.put(jutalomfalatka, 0);
        this.eszkoztar.put(konzervKutyaeledel, 0);
        this.eszkoztar.put(kutyaEnergiaital, 0);
        this.eszkoztar.put(maximalizaloItal, 0);
        this.eszkoztar.put(szarazKutyatap, 0);
        this.eszkoztar.put(viz, 0);
    }

    //felhasznál valamit az eszköztárból
    public void felhasznalEszkoz(Eszkoz eszkoz){
        for (Eszkoz key : getEszkoztar().keySet()){
            if(key.getClass() == eszkoz.getClass()){
                hasznal(key);
                this.eszkoztar.put(key, getEszkoztar().get(key)-1);
                break;
            }
        }
    }

    public Map<Eszkoz, Integer> getEszkoztar() {
        return eszkoztar;
    }

    //van-e elég pénz a vásárláshoz
    public boolean vanPenz(Eszkoz eszkoz){
        if(Math.abs(eszkoz.getTulajdonsagok().getPenz()) > getTulajdonsagok().getPenz()){
            System.err.println("Nincs elég pénz!");
            return false;
        }
        return true;
    }

    //van-e energia a tevékenységhez
    public boolean vanEnergia(Eszkoz eszkoz){
        if(getTulajdonsagok().getEnergia() < 10 || Math.abs(eszkoz.getTulajdonsagok().getEnergia()) > getTulajdonsagok().getEnergia()){
            System.err.println("Nincs elég energia!");
            return false;
        }
        return true;
    }


    // az egészségtelenségbe, az éhínségbe és a szomorúságba belehal a kutya
    public void meghal(){
        String ok = "";
        if(getTulajdonsagok().getEgeszseg() == 0) {
            egeszsegtelen++;
            if(egeszsegtelen >= 3){
                ok = "Sérülések";
                this.elet = false;
            }
        }
        if(getTulajdonsagok().getJollakottsag() == 0){
            ehes++;
            if(ehes >= 7){
                ok = "Éhség";
                this.elet = false;
            }
        }
        if(getTulajdonsagok().getKedv() == 0){
            szomoru++;
            if(szomoru >= 12){
                ok = "Szomorúság";
                this.elet = false;
            }
        }
        if(!elet){
            StringBuilder sb = new StringBuilder();
            sb.append(getNev()).append(" meghalt. \nHalál oka: ").append(ok);
            System.err.println(sb);
        }
    }

    //elég alacsony-e a rendetlenség
    public boolean nemRendetlen(){
        if(getTulajdonsagok().getRendetlenseg() >= 40){
            System.err.println("Túl nagy a rendetlenség!");
            return false;
        }
        return true;
    }

    //aludni tud koszosan, viszont egyre több egészségbe fog kerülni
    public void alszik(){
        if(isTiszta()){
            this.koszreteg = 0;
        }
        else{
            this.koszreteg++;
        }
        hasznal(new Felhasznalhato("alvás", Tulajdonsagok.random(new Tulajdonsagok(-8, -5 - (2*koszreteg), 0, 0, 0, 0), "energia", 30, 50)));
        koszosodik();
    }

    //40%, hogy koszos lesz alvás után
    private void koszosodik(){
        Random random = new Random();
        if(random.nextInt(100) < 40){
            this.tiszta = false;
        }
    }

    public void furdet(){
        this.tiszta = true;
    }

    //ha koszos a kutya, csak fürödni és aludni tud
    public boolean tisztaKutya(){
        if(!this.tiszta){
            System.err.println("A kutyát meg kell fürdetni!");
            return false;
        }
        return true;
    }
}
