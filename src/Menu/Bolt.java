package Menu;
import Eszkozok.*;
import Eszkozok.Felhasznalhato.*;
import Kiegeszites.Szinek;
import Kutyak.Kutya;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Bolt extends Menu{
    private Map<String, Eszkoz> lehetosegek;

    public Bolt(Kutya kutya){
        lehetosegek = new HashMap<>();
        this.lehetosegek.put("",new Felhasznalhato("", kutya.getTulajdonsagok()));
        this.lehetosegek.put("1",new Csont());
        this.lehetosegek.put("2",new Hazikoszt());
        this.lehetosegek.put("3",new Jutalomfalatka());
        this.lehetosegek.put("4",new KonzervKutyaeledel());
        this.lehetosegek.put("5",new KutyaEnergiaital());
        this.lehetosegek.put("6",new MaximalizaloItal());
        this.lehetosegek.put("7",new SzarazKutyatap());
        this.lehetosegek.put("8",new Viz());
    }


    public Map<String, Eszkoz> getLehetosegek() {
        return lehetosegek;
    }
}
