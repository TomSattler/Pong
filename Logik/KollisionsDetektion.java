package Logik;

import Ui.Spielfeld;

public class KollisionsDetektion {
    Spieler spielerEins;
    Spieler spielerZwei;
    Spielfeld spielfeld;

    public KollisionsDetektion(Spieler spielerEins, Spieler spielerZwei, Spielfeld spielfeld){
        this.spielerEins = spielerEins;
        this.spielerZwei = spielerZwei;
        this.spielfeld = spielfeld;
    }

    public boolean checkBeruehrungMitSpielfeldGrenzen(Ball ball){
        return ball.rechteck.getY() <= this.spielfeld.getSpielfeldHoehe() / 10 ||
                ball.rechteck.getY() >= this.spielfeld.getSpielfeldHoehe() / 10 + this.spielfeld.getSpielfeldHoehe()- (2 * this.spielfeld.getSpielfeldHoehe()/10);
    }

    public boolean checkBeruehrungMitSchlaeger(Ball ball){
        return ball.rechteck.ueberschneidet(spielerEins.getSchlaeger()) ||
                ball.rechteck.ueberschneidet(spielerZwei.getSchlaeger());
    }
}
