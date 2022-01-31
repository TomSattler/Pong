package Ui;

import Logik.Ball;
import Logik.KollisionsDetektion;
import Logik.Spieler;
import Util.Interaktionsbrett;

public class PongSpiel {
    private Ball ball;
    private Spieler spielerEins;
    private Spieler spielerZwei;
    private Spielfeld spielfeld;
    private Interaktionsbrett ib;
    private boolean spielen=true;
    private static long FPMS = 17;

    public PongSpiel(){
        this.ib = new Interaktionsbrett();
        this.ib.willTasteninfo(this);
        this.startAufstellung();
        this.spielfeld.darstellen();
    }

    public void spielen(){
        while(spielerEins.getPunkte()<10&&spielerZwei.getPunkte()<10) {
            spielDarstellen();
            if (ball.rechteck.getX() < this.spielfeld.getSpielfeldBreite() / 100) {
                spielerEinsVerlorenZuruecksetzen();
            }
            if (ball.rechteck.getX() > this.spielfeld.getSpielfeldBreite() / 100 + this.spielfeld.getSpielfeldBreite() - 2 * this.spielfeld.getSpielfeldBreite() / 100) {
                spielerZweiVerlorenZuruecksetzen();
            }
            try {
                Thread.sleep(FPMS);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        gewinnerAnzeigen();
    }
    private void gewinnerAnzeigen(){
        if(spielerEins.getPunkte()>=10){
            this.ib.textZeigen("Spieler Eins gewinnt!");
        }
        else if(spielerZwei.getPunkte()>=10) {
            this.ib.textZeigen(("Spieler Zwei gewinnt!"));
        }
    }
    private void spielDarstellen(){
        this.ib.abwischen();
        this.ib.textZeigen("Spieler 1: " + spielerEins.getPunkte() + "   Spieler 2: " + spielerZwei.getPunkte());
        if(!spielen) {
            this.ball.bewegen(17);
        }
        else{
            this.ib.textZeigen("Pause");
        }
        this.spielfeld.darstellen();
        this.ball.darstellen();
        this.spielerEins.schlaegerDarstellen();
        this.spielerZwei.schlaegerDarstellen();
    }
    private void spielerEinsVerlorenZuruecksetzen(){
        this.spielerEins.schlaegerPositionZuruecksetzen1();
        this.spielerZwei.schlaegerPositionZuruecksetzen2();
        this.ball.neueRunde(1);
        this.spielerZwei.erhoehePunkte();
    }

    private void spielerZweiVerlorenZuruecksetzen(){
        this.spielerZwei.schlaegerPositionZuruecksetzen2();
        this.spielerEins.schlaegerPositionZuruecksetzen1();
        this.ball.neueRunde(2);
        this.spielerEins.erhoehePunkte();
    }

    public void tasteGedrueckt(String s){
        switch (s){
            case "a":
                this.spielerEins.abwaerts();
                break;
            case "y":
                this.spielerEins.aufwaerts();
                break;
            case "o":
                this.spielerZwei.abwaerts();
                break;
            case "l":
                this.spielerZwei.aufwaerts();
                break;
            case "s":
                this.spielen = !spielen;
                break;
            case "e":
                System.exit(1);
        }
    }

    private void startAufstellung(){
        this.spielfeld = new Spielfeld(this.ib);
        this.spielerEins = new Spieler(this.spielfeld, this.spielfeld.getSpielfeldHoehe(),this.spielfeld.getSpielfeldBreite(), 1);
        this.spielerZwei = new Spieler(this.spielfeld, this.spielfeld.getSpielfeldHoehe(),this.spielfeld.getSpielfeldBreite(), 2);
        KollisionsDetektion kollisionsDetektion = new KollisionsDetektion(this.spielerEins, this.spielerZwei, this.spielfeld);
        this.ball = new Ball(4, 2, kollisionsDetektion);
        this.ball.ballInitialisieren(400, 400);
        this.ball.darstellen();
        spielen();
    }
}
