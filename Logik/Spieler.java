package Logik;

import Ui.Rechteck;
import Ui.Spielfeld;

public class Spieler{
    private Spielfeld spielfeld;
    private Rechteck schlaeger;
    private int punkte = 0;
    private static int bewegFaktor = 20;

    public Spieler(Spielfeld spielfeld, int spielfeldHoehe, int spielfeldBreite, int welcherSpieler){
        switch (welcherSpieler) {
            case 1 -> {
                this.spielfeld = spielfeld;
                this.schlaeger = new Rechteck(3 * spielfeldBreite / 100, (spielfeldHoehe / 2) - (spielfeldHoehe / 16), spielfeldHoehe / 8, 4 * spielfeldBreite / 200);
                this.schlaeger.darstellenRahmen(this.spielfeld.getIb());
                this.schlaeger.darstellenFuellung(this.spielfeld.getIb());
            }
            case 2 -> {
                this.spielfeld = spielfeld;
                this.schlaeger = new Rechteck((spielfeldBreite - 3 * spielfeldBreite / 100) - 4 * spielfeldBreite / 200, spielfeldHoehe / 2 - spielfeldHoehe / 16, spielfeldHoehe / 8, 4 * spielfeldBreite / 200);
                this.schlaeger.darstellenRahmen(this.spielfeld.getIb());
                this.schlaeger.darstellenFuellung(this.spielfeld.getIb());
            }
        }
    }
    public void schlaegerPositionZuruecksetzen2(){
        this.schlaeger = new Rechteck((this.spielfeld.getSpielfeldBreite() - 3 * this.spielfeld.getSpielfeldBreite() / 100) - 4 * this.spielfeld.getSpielfeldBreite() / 200, this.spielfeld.getSpielfeldHoehe() / 2 - this.spielfeld.getSpielfeldHoehe() / 16, this.spielfeld.getSpielfeldHoehe() / 8, 4 * this.spielfeld.getSpielfeldBreite() / 200);
    }
    public void schlaegerPositionZuruecksetzen1() {
        this.schlaeger = new Rechteck(3 * this.spielfeld.getSpielfeldBreite() / 100, (this.spielfeld.getSpielfeldHoehe() / 2) - (this.spielfeld.getSpielfeldHoehe() / 16), this.spielfeld.getSpielfeldHoehe() / 8, 4 * this.spielfeld.getSpielfeldBreite() / 200);
    }
    public void schlaegerDarstellen(){
        this.schlaeger.darstellenRahmen(this.spielfeld.getIb());
        this.schlaeger.darstellenFuellung(this.spielfeld.getIb());
    }
    public void aufwaerts() {
        if(this.schlaeger.getY()<this.spielfeld.getSpielfeldHoehe() - 22 * this.spielfeld.getSpielfeldHoehe()/100)
        this.schlaeger.verschiebeVertikal(bewegFaktor);
    }
    public void abwaerts(){
        if(this.schlaeger.getY()>this.spielfeld.getSpielfeldHoehe()/10) {
            this.schlaeger.verschiebeVertikal(-bewegFaktor);
        }
    }

    public Rechteck getSchlaeger() {
        return schlaeger;
    }

    public int getPunkte() {
        return this.punkte;
    }
    public void erhoehePunkte(){
        this.punkte++;
    }

    void spielfeldEinbinden(Spielfeld spielfeld){
    this.spielfeld=spielfeld;
    }
}
