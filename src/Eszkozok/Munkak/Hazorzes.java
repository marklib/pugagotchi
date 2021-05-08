package Eszkozok.Munkak;

import Eszkozok.Tulajdonsagok;
import Kiegeszites.Szinek;

public class Hazorzes extends Munka {
    private int minEgeszseg = -20;
    private int maxEgeszseg = -10;
    private int minEnergia = -30;
    private int maxEnergia = -8;
    private int minPenz = 30;
    private int maxPenz = 200;

    public Hazorzes(){
        super("Házőrzés", new Tulajdonsagok(0, -20, -30, -30, 30, 200));
    }

    public int getMinEgeszseg() {
        return minEgeszseg;
    }

    public int getMaxEgeszseg() {
        return maxEgeszseg;
    }

    public int getMinEnergia() {
        return minEnergia;
    }

    public int getMaxEnergia() {
        return maxEnergia;
    }

    public int getMinPenz() {
        return minPenz;
    }

    public int getMaxPenz() {
        return maxPenz;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(Szinek.RESET);
        sb.append(getNev());
        sb.append(": ");

        if(getTulajdonsagok().getJollakottsag() != 0){
            sb.append(Szinek.YELLOW);
            if(getTulajdonsagok().getJollakottsag() > 0){
                sb.append("+");
            }
            sb.append(getTulajdonsagok().getJollakottsag());
            sb.append(" Jóllakottság");
            sb.append(Szinek.RESET);
            sb.append(" | ");
        }

        if(getTulajdonsagok().getEgeszseg() != 0){
            sb.append(Szinek.GREEN2);
            sb.append("-[").append(Math.abs(getMaxEgeszseg()));
            sb.append("-").append(Math.abs(getMinEgeszseg())).append("]");
            sb.append(" Egészség");
            sb.append(Szinek.RESET);
            sb.append(" | ");
        }

        if(getTulajdonsagok().getKedv() != 0){
            sb.append(Szinek.PURPLE2);
            if(getTulajdonsagok().getKedv() > 0){
                sb.append("+");
            }
            sb.append(getTulajdonsagok().getKedv());
            sb.append(" Kedv");
            sb.append(Szinek.RESET);
            sb.append(" | ");
        }

        if(getTulajdonsagok().getEnergia() != 0){
            sb.append(Szinek.CYAN2);
            sb.append("-[").append(Math.abs(getMaxEnergia()));
            sb.append("-").append(Math.abs(getMinEnergia())).append("]");
            sb.append(" Energia");
            sb.append(Szinek.RESET);
            sb.append(" | ");
        }

        if(getTulajdonsagok().getRendetlenseg() != 0){
            sb.append(Szinek.WHITE2);
            if(getTulajdonsagok().getRendetlenseg() > 0){
                sb.append("+");
            }
            sb.append(getTulajdonsagok().getRendetlenseg());
            sb.append(" Rendetlenség");
            sb.append(Szinek.RESET);
            sb.append(" | ");
        }

        if(getTulajdonsagok().getPenz() != 0){
            sb.append(Szinek.RED2);
            sb.append("+[").append(Math.abs(getMinPenz()));
            sb.append("-").append(Math.abs(getMaxPenz())).append("]");
            sb.append(" Pénz");
            sb.append(Szinek.RESET);
            sb.append(" | ");
        }

        return sb.toString();
    }
}
