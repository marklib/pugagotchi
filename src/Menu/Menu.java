package Menu;

import Eszkozok.Eszkoz;
import Kiegeszites.Szinek;
import Iranyitas.*;
import Kutyak.Kutya;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Menu {
    public static final String MENU_FO = "FOMENU";
    public static final String MENU_BOLT = "BOLT";
    public static final String MENU_MUNKA = "MUNKA";
    public static final String MENU_JATEK = "JATEK";
    public static final String MENU_GYOGYIT = "GYOGYITAS";
    public static final String MENU_ESZKOZTAR = "ESZKOZTAR";
    public static String MENU_MOST = MENU_FO;
    protected static Iranyitas iranyitas = new Iranyitas();

    //private static Map<String, ArrayList<String>> lehetosegek;

    //kiírja a kutya adatait, a menüt, és várja egy menüpont megadását
    public static String menu(Map<String, Eszkoz> lehetosegek, Kutya kutya){
        StringBuilder sb = new StringBuilder();
        Set<String> keys;
        sb.append(Szinek.BLACK2_BOLD);
        sb.append("\n################\n");
        sb.append(Szinek.RESET);
        sb.append(kutya.getNev()).append(" adatai").append(lehetosegek.get("").kutya());
        if(!kutya.isTiszta()){
            sb.append(Szinek.RED2_BOLD).append(" KOSZOS");
        }
        sb.append(Szinek.WHITE2_BOLD);
        sb.append("\n---- ").append(MENU_MOST).append(" ----");
        if(MENU_MOST.equals(MENU_FO)){

            keys = new HashSet<>(Arrays.asList("1","2","3","4","5","6","n"));
            sb.append(Szinek.RESET);
            sb.append("\n[1] ESZKÖZTÁR\n");
            sb.append("[2] BOLT\n");
            sb.append("[3] GYÓGYÍTÁS\n");
            sb.append("[4] JÁTÉK\n");
            sb.append("[5] MUNKA\n");
            sb.append("[6] FÜRDETÉS\n");
            sb.append("[n] ALVÁS (nap vége)");
        }
        else{
            keys = new HashSet<>(lehetosegek.keySet());
            keys.remove("");
            for (String key: keys) {
                sb.append(Szinek.RESET);
                sb.append("\n");
                sb.append("[").append(key).append("] ");
                if(MENU_MOST.equals(MENU_ESZKOZTAR)){
                    for(Eszkoz eszkoz : kutya.getEszkoztar().keySet()){
                        if(eszkoz.getClass() == lehetosegek.get(key).getClass()){
                            sb.append(String.valueOf(kutya.getEszkoztar().get(eszkoz))).append("x ");
                        }
                    }
                }
                sb.append(lehetosegek.get(key));
            }
            keys.add("b");
            sb.append(Szinek.RESET);
            sb.append("\n[b] VISSZA A FŐMENÜBE");
        }
        System.out.println(sb);

        return iranyitas.valaszt(keys);
    }

    /*private static String egyeb(){
        StringBuilder sb = new StringBuilder();
        if (MENU_FO.equals(MENU_MOST)) {
            sb.append(Szinek.RESET);
            sb.append("[1] ESZKÖZTÁR\n");
            sb.append("[2] BOLT\n");
            sb.append("[3] GYÓGYÍTÁS\n");
            sb.append("[4] JÁTÉK\n");
            sb.append("[5] MUNKA\n");
            sb.append("[n] ALVÁS (nap vége)\n");
            //System.out.println(sb);
            return "n";
        } else {
            sb.append("[b] VISSZA A FŐMENÜBE\n");
            return "b";
        }
    }*/
}
