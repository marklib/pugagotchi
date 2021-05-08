package Eszkozok.Felhasznalhato;
import Eszkozok.Eszkoz;
import Eszkozok.Tulajdonsagok;

public class Felhasznalhato extends Eszkoz {
    public Felhasznalhato(String nev, Tulajdonsagok tulajdonsagok){
        super(nev, tulajdonsagok);
    }

    public void megvesz(){
        this.megvasarolt();
    }
}
