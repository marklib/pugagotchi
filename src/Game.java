import Eszkozok.Eszkoz;
import Eszkozok.Jatek.*;
import Eszkozok.Munkak.*;
import Eszkozok.Tulajdonsagok;
import Kutyak.Kutya;
import Eszkozok.Felhasznalhato.*;
import Menu.*;
import Kiegeszites.Szinek;

import java.util.Scanner;

public class Game {

    private static Kutya start(){
        System.out.println("A menüpontok kiválasztása a szögletes zárójelek közötti karakter(ek) beírásával történik.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Adja meg a kutya és a kutya tulajdonosának nevét!\nKutya neve: ");
        String dog = scanner.nextLine();
        System.out.print("Tulajdonos neve: ");
        return new Kutya(dog, scanner.nextLine());
    }

    public static void main(String[] args){
        Kutya kutya = start();
        String menupont;
        for(int turn = 0; turn < 100 && kutya.getElet(); turn++){
            boolean endTurn = false;
            while(!endTurn){
                switch (Menu.MENU_MOST){
                    case Menu.MENU_FO:
                        switch (Menu.menu(new Fomenu(kutya).getLehetosegek(), kutya)){
                            case "1": //ESZKOZTAR
                                if(kutya.tisztaKutya()){
                                    Menu.MENU_MOST = Menu.MENU_ESZKOZTAR;
                                }
                                break;

                            case "2": //BOLT
                                if(kutya.tisztaKutya()){
                                    Menu.MENU_MOST = Menu.MENU_BOLT;
                                }
                                break;

                            case "3": //GYOGYITAS
                                if(kutya.tisztaKutya()){
                                    Menu.MENU_MOST = Menu.MENU_GYOGYIT;
                                }
                                break;

                            case "4": //JATEK
                                if(kutya.tisztaKutya()){
                                    Menu.MENU_MOST = Menu.MENU_JATEK;
                                }
                                break;

                            case "5": //MUNKA
                                if(kutya.tisztaKutya()){
                                    Menu.MENU_MOST = Menu.MENU_MUNKA;
                                }
                                break;

                            case "6": //FÜRDETÉS
                                kutya.furdet();
                                break;

                            case "n": //KOR VEGE
                                kutya.alszik();
                                endTurn = true;
                                if(turn == 99){
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(Szinek.GREEN2_BOLD);
                                    sb.append("Gratulálunk, ").append(kutya.getTulajdonos()).append("!\n");
                                    sb.append(kutya.getNev()).append(" ezennel túlélt 100 napot!\n");
                                    sb.append("A játéknak vége, és Ön egy újabb győzelemmel lett gazdagabb!");
                                    System.out.println(sb);
                                }
                                break;
                        }
                        break;

                    case Menu.MENU_ESZKOZTAR:
                        Eszkoztar eszkoztar = new Eszkoztar(kutya);
                        menupont = Menu.menu(eszkoztar.getLehetosegek(), kutya);
                        if(menupont.equals("b")){
                            Menu.MENU_MOST = Menu.MENU_FO;
                        }
                        else{
                            kutya.felhasznalEszkoz(eszkoztar.getLehetosegek().get(menupont));
                        }
                        break;

                    case Menu.MENU_BOLT:
                        Bolt bolt = new Bolt(kutya);
                        menupont = Menu.menu(bolt.getLehetosegek(), kutya);
                        if(menupont.equals("b")){
                            Menu.MENU_MOST = Menu.MENU_FO;
                        }
                        else{
                            Eszkoz lehetoseg = bolt.getLehetosegek().get(menupont);
                            if(kutya.vanPenz(lehetoseg)){
                                kutya.vasarol((Felhasznalhato)lehetoseg);
                            }
                        }
                        break;

                    case Menu.MENU_GYOGYIT:
                        Gyogyitas gyogyitas = new Gyogyitas(kutya);
                        menupont = Menu.menu(gyogyitas.getLehetosegek(), kutya);
                        if(menupont.equals("b")) {
                            Menu.MENU_MOST = Menu.MENU_FO;
                        }
                        else{
                            Eszkoz lehetoseg = gyogyitas.getLehetosegek().get(menupont);
                            if(kutya.vanPenz(lehetoseg)){
                                kutya.hasznal(lehetoseg);
                            }
                        }
                        break;

                    case Menu.MENU_JATEK:
                        JatekMenu jatekMenu = new JatekMenu(kutya);
                        menupont = Menu.menu(jatekMenu.getLehetosegek(), kutya);
                        if(menupont.equals("b")){
                            Menu.MENU_MOST = Menu.MENU_FO;
                        }
                        else{
                            Eszkoz lehetoseg = jatekMenu.getLehetosegek().get(menupont);
                            if(kutya.vanEnergia(lehetoseg) && kutya.vanPenz(lehetoseg)){
                                if(lehetoseg.getClass().equals(LabdasJatek.class)){
                                    kutya.hasznal(new Jatek("", Tulajdonsagok.random(lehetoseg.getTulajdonsagok(), "egeszseg", ((LabdasJatek) lehetoseg).getMinEgeszseg(), ((LabdasJatek) lehetoseg).getMaxEgeszseg())));
                                }
                                else{
                                    kutya.hasznal(lehetoseg);
                                }
                            }
                        }
                        break;

                    case Menu.MENU_MUNKA:
                        MunkaMenu munkaMenu = new MunkaMenu(kutya);
                        menupont = Menu.menu(munkaMenu.getLehetosegek(), kutya);
                        if(menupont.equals("b")){
                            Menu.MENU_MOST = Menu.MENU_FO;
                        }
                        else {
                            Eszkoz lehetoseg = munkaMenu.getLehetosegek().get(menupont);
                            //switchre hibát mutatott
                            if(kutya.vanEnergia(lehetoseg) && kutya.nemRendetlen()){
                                if(lehetoseg.getClass().equals(RendoriSegitseg.class)){
                                    kutya.hasznal(new Munka("", Tulajdonsagok.random(lehetoseg.getTulajdonsagok(), "egeszseg", ((RendoriSegitseg) lehetoseg).getMinEgeszseg(), ((RendoriSegitseg) lehetoseg).getMaxEgeszseg())));
                                }
                                else if(lehetoseg.getClass().equals(Hazorzes.class)){
                                    kutya.hasznal(new Munka("", Tulajdonsagok.random(Tulajdonsagok.random(Tulajdonsagok.random(lehetoseg.getTulajdonsagok(), "penz", ((Hazorzes) lehetoseg).getMinPenz(), ((Hazorzes) lehetoseg).getMaxPenz()), "energia", ((Hazorzes) lehetoseg).getMinEnergia(), ((Hazorzes) lehetoseg).getMaxEnergia()), "egeszseg", ((Hazorzes) lehetoseg).getMinEgeszseg(), ((Hazorzes) lehetoseg).getMaxEgeszseg())));
                                }
                                else{
                                    kutya.hasznal(lehetoseg);
                                }
                            }
                        }
                        break;
                }
            }
        }

    }
}
