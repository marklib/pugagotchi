package Eszkozok;
import Kiegeszites.Szinek;

abstract public class Eszkoz {
    private String nev;
    private Tulajdonsagok tulajdonsagok;

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Eszkoz(String nev, Tulajdonsagok tulajdonsagok){
        setNev(nev);
        this.tulajdonsagok = tulajdonsagok;
    }

    public Tulajdonsagok getTulajdonsagok(){
        return tulajdonsagok;
    }

    protected void megvasarolt(){
        this.tulajdonsagok.setPenz(0);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(Szinek.RESET);
        sb.append(getNev());
        sb.append(": ");

        if(tulajdonsagok.getJollakottsag() != 0){
            sb.append(Szinek.YELLOW);
            if(tulajdonsagok.getJollakottsag() > 0){
                sb.append("+");
            }
            sb.append(tulajdonsagok.getJollakottsag());
            sb.append(" Jóllakottság");
            sb.append(Szinek.RESET);
            sb.append(" | ");
        }

        if(tulajdonsagok.getEgeszseg() != 0){
            sb.append(Szinek.GREEN2);
            if(tulajdonsagok.getEgeszseg() > 0){
                sb.append("+");
            }
            sb.append(tulajdonsagok.getEgeszseg());
            sb.append(" Egészség");
            sb.append(Szinek.RESET);
            sb.append(" | ");
        }

        if(tulajdonsagok.getKedv() != 0){
            sb.append(Szinek.PURPLE2);
            if(tulajdonsagok.getKedv() > 0){
                sb.append("+");
            }
            sb.append(tulajdonsagok.getKedv());
            sb.append(" Kedv");
            sb.append(Szinek.RESET);
            sb.append(" | ");
        }

        if(tulajdonsagok.getEnergia() != 0){
            sb.append(Szinek.CYAN2);
            if(tulajdonsagok.getEnergia() > 0){
                sb.append("+");
            }
            sb.append(tulajdonsagok.getEnergia());
            sb.append(" Energia");
            sb.append(Szinek.RESET);
            sb.append(" | ");
        }

        if(tulajdonsagok.getRendetlenseg() != 0){
            sb.append(Szinek.WHITE2);
            if(tulajdonsagok.getRendetlenseg() > 0){
                sb.append("+");
            }
            sb.append(tulajdonsagok.getRendetlenseg());
            sb.append(" Rendetlenség");
            sb.append(Szinek.RESET);
            sb.append(" | ");
        }

        if(tulajdonsagok.getPenz() != 0){
            sb.append(Szinek.RED2);
            if(tulajdonsagok.getPenz() > 0){
                sb.append("+");
            }
            sb.append(tulajdonsagok.getPenz());
            sb.append(" Pénz");
            sb.append(Szinek.RESET);
            sb.append(" | ");
        }

        return sb.toString();
    }

    public String kutya(){
        StringBuilder sb = new StringBuilder();
        sb.append(Szinek.RESET);
        sb.append(getNev());
        sb.append(": ");

            sb.append(Szinek.YELLOW);
            if(tulajdonsagok.getJollakottsag() > 0){
                sb.append("+");
            }
            sb.append(tulajdonsagok.getJollakottsag());
            sb.append(" Jóllakottság");
            sb.append(Szinek.RESET);
            sb.append(" | ");

            sb.append(Szinek.GREEN2);
            if(tulajdonsagok.getEgeszseg() > 0){
                sb.append("+");
            }
            sb.append(tulajdonsagok.getEgeszseg());
            sb.append(" Egészség");
            sb.append(Szinek.RESET);
            sb.append(" | ");

            sb.append(Szinek.PURPLE2);
            if(tulajdonsagok.getKedv() > 0){
                sb.append("+");
            }
            sb.append(tulajdonsagok.getKedv());
            sb.append(" Kedv");
            sb.append(Szinek.RESET);
            sb.append(" | ");

            sb.append(Szinek.CYAN2);
            if(tulajdonsagok.getEnergia() > 0){
                sb.append("+");
            }
            sb.append(tulajdonsagok.getEnergia());
            sb.append(" Energia");
            sb.append(Szinek.RESET);
            sb.append(" | ");

            sb.append(Szinek.WHITE2);
            if(tulajdonsagok.getRendetlenseg() > 0){
                sb.append("+");
            }
            sb.append(tulajdonsagok.getRendetlenseg());
            sb.append(" Rendetlenség");
            sb.append(Szinek.RESET);
            sb.append(" | ");

            sb.append(Szinek.RED2);
            if(tulajdonsagok.getPenz() > 0){
                sb.append("+");
            }
            sb.append(tulajdonsagok.getPenz());
            sb.append(" Pénz");
            sb.append(Szinek.RESET);
            sb.append(" | ");

        return sb.toString();
    }
}
