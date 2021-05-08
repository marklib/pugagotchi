package Menu;

import Eszkozok.Eszkoz;
import Eszkozok.Felhasznalhato.Felhasznalhato;
import Kutyak.Kutya;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Eszkoztar extends Menu{
    private Map<String, Eszkoz> lehetosegek;

    public Eszkoztar(Kutya kutya){
        lehetosegek = new HashMap<>();
        lehetosegek.put("",new Felhasznalhato("", kutya.getTulajdonsagok()));
        Map<Eszkoz, Integer> eszkoztar = new HashMap<>(kutya.getEszkoztar());
        Set<Eszkoz> keys = new HashSet<>(eszkoztar.keySet());
        int n = 1;
        for (Eszkoz key : keys){
            if(eszkoztar.get(key) > 0){
                lehetosegek.put(String.valueOf(n), key);
                n++;
            }
        }
    }

    public Map<String, Eszkoz> getLehetosegek(){
        return this.lehetosegek;
    }
}
