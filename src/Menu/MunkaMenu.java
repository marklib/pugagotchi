package Menu;

import Eszkozok.Eszkoz;
import Eszkozok.Munkak.*;
import Kutyak.Kutya;

import java.util.HashMap;
import java.util.Map;

public class MunkaMenu extends Menu{
    private Map<String, Eszkoz> lehetosegek;

    public MunkaMenu(Kutya kutya){
        lehetosegek = new HashMap<>();
        this.lehetosegek.put("",new Munka("", kutya.getTulajdonsagok()));
        this.lehetosegek.put("1",new Ujsagkihordas());
        this.lehetosegek.put("2",new RendoriSegitseg());
        this.lehetosegek.put("3",new Hazorzes());
    }


    public Map<String, Eszkoz> getLehetosegek() {
        return lehetosegek;
    }
}
