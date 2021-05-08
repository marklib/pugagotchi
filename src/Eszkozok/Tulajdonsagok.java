package Eszkozok;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Tulajdonsagok {

    private Map<String, Integer> tulajdonsagok;

    public Tulajdonsagok(int jollakottsag, int egeszseg, int kedv, int energia, int rendetlenseg, int penz){
        tulajdonsagok = new HashMap<>();
        tulajdonsagok.put("jollakottsag", jollakottsag);
        tulajdonsagok.put("egeszseg", egeszseg);
        tulajdonsagok.put("kedv", kedv);
        tulajdonsagok.put("energia", energia);
        tulajdonsagok.put("rendetlenseg", rendetlenseg);
        tulajdonsagok.put("penz", penz);
    }

    public int getJollakottsag() {
        return tulajdonsagok.get("jollakottsag");
    }

    public void setJollakottsag(int jollakottsag) {
        if(jollakottsag > 100){
            jollakottsag = 100;
        }
        else if(jollakottsag < 0){
            jollakottsag = 0;
        }
        this.tulajdonsagok.put("jollakottsag", jollakottsag);
    }

    public int getEgeszseg() {
        return tulajdonsagok.get("egeszseg");
    }

    public void setEgeszseg(int egeszseg) {
        if(egeszseg > 100){
            egeszseg = 100;
        }
        else if(egeszseg < 0){
            egeszseg = 0;
        }
        this.tulajdonsagok.put("egeszseg", egeszseg);
    }

    public int getKedv() {
        return tulajdonsagok.get("kedv");
    }

    public void setKedv(int kedv) {
        if(kedv > 100){
            kedv = 100;
        }
        else if(kedv < 0){
            kedv = 0;
        }
        this.tulajdonsagok.put("kedv", kedv);
    }

    public int getEnergia() {
        return tulajdonsagok.get("energia");
    }

    public void setEnergia(int energia) {
        if(energia > 100){
            energia = 100;
        }
        else if(energia < 0){
            energia = 0;
        }
        this.tulajdonsagok.put("energia", energia);
    }

    public int getRendetlenseg() {
        return tulajdonsagok.get("rendetlenseg");
    }

    public void setRendetlenseg(int rendetlenseg) {
        if(rendetlenseg > 100){
            rendetlenseg = 100;
        }
        else if(rendetlenseg < 0){
            rendetlenseg = 0;
        }
        this.tulajdonsagok.put("rendetlenseg", rendetlenseg);
    }

    public int getPenz() {
        return tulajdonsagok.get("penz");
    }

    public void setPenz(int penz) {
        this.tulajdonsagok.put("penz",penz);
    }

    //összeadja 2 Tulajdonsagok adatait
    public void felhasznal(Tulajdonsagok modositas){
        setJollakottsag(getJollakottsag() + modositas.getJollakottsag());
        setEgeszseg(getEgeszseg() + modositas.getEgeszseg());
        setKedv(getKedv() + modositas.getKedv());
        setEnergia(getEnergia() + modositas.getEnergia());
        setRendetlenseg(getRendetlenseg() + modositas.getRendetlenseg());
        setPenz(getPenz() + modositas.getPenz());
    }

    //randomizál egy adatot egy Tulajdonsagok-ban, majd visszatér az egész Tulajdonsagok-kal
    public static Tulajdonsagok random(Tulajdonsagok tulajdonsagok, String tulajdonsag, int min, int max){
        //Tulajdonsagok ujTulajdonsagok = new Tulajdonsagok(tulajdonsagok.getJollakottsag(), tulajdonsagok.getEgeszseg(), tulajdonsagok.getKedv(), tulajdonsagok.getEnergia(), tulajdonsagok.getRendetlenseg(), tulajdonsagok.getPenz());
        Random r = new Random();
        int uj = r.nextInt(max - min) + min;
        tulajdonsagok.tulajdonsagok.put(tulajdonsag, uj);
        return tulajdonsagok;
    }
}
