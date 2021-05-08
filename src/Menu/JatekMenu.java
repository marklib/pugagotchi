package Menu;

import Eszkozok.Eszkoz;
import Eszkozok.Jatek.*;
import Kutyak.Kutya;

import java.util.HashMap;
import java.util.Map;

public class JatekMenu extends Menu{
    private Map<String, Eszkoz> lehetosegek;

    public JatekMenu(Kutya kutya){
        lehetosegek = new HashMap<>();
        this.lehetosegek.put("",new Jatek("", kutya.getTulajdonsagok()));
        this.lehetosegek.put("1",new Seta());
        this.lehetosegek.put("2",new Park());
        this.lehetosegek.put("3",new LabdasJatek());
        this.lehetosegek.put("4",new Kutyaiskola());
    }


    public Map<String, Eszkoz> getLehetosegek() {
        return lehetosegek;
    }
}
