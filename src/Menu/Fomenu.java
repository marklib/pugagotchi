package Menu;

import Eszkozok.Eszkoz;
import Eszkozok.Felhasznalhato.Felhasznalhato;
import Eszkozok.Tulajdonsagok;
import Kutyak.Kutya;

import java.util.HashMap;
import java.util.Map;

public class Fomenu extends Menu{
    private Map<String, Eszkoz> lehetosegek;

    public Fomenu(Kutya kutya){
        lehetosegek = new HashMap<>();
        lehetosegek.put("",new Felhasznalhato("", kutya.getTulajdonsagok()));
    }

    public Map<String, Eszkoz> getLehetosegek(){
        return this.lehetosegek;
    }
}
