package Menu;

import Eszkozok.Eszkoz;
import Eszkozok.Gyogyitas.*;
import Kutyak.Kutya;

import java.util.HashMap;
import java.util.Map;

public class Gyogyitas extends Menu{
    private Map<String, Eszkoz> lehetosegek;

    public Gyogyitas(Kutya kutya){
        lehetosegek = new HashMap<>();
        this.lehetosegek.put("",new Gyogy("", kutya.getTulajdonsagok()));
        this.lehetosegek.put("1",new KisEletcsomag());
        this.lehetosegek.put("2",new NagyEletcsomag());
        this.lehetosegek.put("3",new Allatorvos());
    }


    public Map<String, Eszkoz> getLehetosegek() {
        return lehetosegek;
    }
}
