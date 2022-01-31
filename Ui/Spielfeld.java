package Ui;

import Util.Interaktionsbrett;

public class Spielfeld {
    private Interaktionsbrett ib;
    Rechteck spielfläche;
    private int spielfeldHoehe;
    private int spielfeldBreite;

    Spielfeld(Interaktionsbrett ib){
        this.ib = ib;
        spielfeldBreite = this.ib.getBreite();
        spielfeldHoehe = this.ib.getHoehe();
        this.spielfläche=new Rechteck(this.spielfeldBreite/100,this.spielfeldHoehe/10, this.spielfeldHoehe- 2 * this.spielfeldHoehe/10, this.spielfeldBreite - 2 * this.spielfeldBreite/100);
    }
    public void darstellen(){
        this.spielfläche.darstellenRahmen(this.ib);
        this.ib.neueLinie(spielfläche.mitteInX(), this.spielfeldHoehe/10, spielfläche.mitteInX(),  this.spielfeldHoehe -  this.spielfeldHoehe/10);
    }
    public Interaktionsbrett getIb(){
        return this.ib;
    }

    public void setIb(Interaktionsbrett ib) {
        this.ib = ib;
    }

    public Rechteck getSpielfläche() {
        return spielfläche;
    }

    public int getSpielfeldBreite() {
        return spielfeldBreite;
    }

    public int getSpielfeldHoehe() {
        return spielfeldHoehe;
    }
}
