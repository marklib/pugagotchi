package Eszkozok.Munkak;

import Eszkozok.Tulajdonsagok;
import Kiegeszites.Szinek;

public class RendoriSegitseg extends Munka{
    private int minEgeszseg = -15;
    private int maxEgeszseg = 0;

    public int getMinEgeszseg() {
        return minEgeszseg;
    }

    public int getMaxEgeszseg() {
        return maxEgeszseg;
    }

    public RendoriSegitseg(){
        super("Rendőri segítség", new Tulajdonsagok(0, -15, -20, -25, 20, 100));
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
            if(getTulajdonsagok().getEgeszseg() > 0){
                sb.append("+");
            }
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
            if(getTulajdonsagok().getEnergia() > 0){
                sb.append("+");
            }
            sb.append(getTulajdonsagok().getEnergia());
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
            if(getTulajdonsagok().getPenz() > 0){
                sb.append("+");
            }
            sb.append(getTulajdonsagok().getPenz());
            sb.append(" Pénz");
            sb.append(Szinek.RESET);
            sb.append(" | ");
        }

        return sb.toString();
    }
}
