package Logik;
import Ui.Rechteck;

public class Ball {
    private int startPositionX;
    private int startPositionY;
    private int bewegungInXProFrame;
    private int bewegungInYProFrame;
    private static int HOEHE = 10;
    private static int BREITE = 10;
    private KollisionsDetektion kollisionsDetektion;
    public Rechteck rechteck;

    public Ball(int x, int y, KollisionsDetektion kollisionsDetektion){
        this.bewegungInXProFrame = x;
        this.bewegungInYProFrame = y;
        this.kollisionsDetektion = kollisionsDetektion;
    }

    public void bewegen(int anzahlFrames){
        if(kollisionsDetektion.checkBeruehrungMitSchlaeger(this)){
            int randomNum = 1 + (int) (Math.random() * 3);
            if(randomNum==2){
                this.bewegungInYProFrame = -this.bewegungInYProFrame;
                this.bewegungInXProFrame = -this.bewegungInXProFrame;
            }
            else {
                this.bewegungInXProFrame = -this.bewegungInXProFrame;
            }
        }
        if(kollisionsDetektion.checkBeruehrungMitSpielfeldGrenzen(this)){
            this.bewegungInYProFrame = -this.bewegungInYProFrame;
        }
        this.rechteck.verschiebeNach(this.rechteck.getX()+this.bewegungInXProFrame, this.rechteck.getY() + this.bewegungInYProFrame);
    }

    public void ballInitialisieren(int x, int y){
        this.rechteck = new Rechteck(x, y, HOEHE, BREITE);
        this.startPositionY = y;
        this.startPositionX = x;
    }

    public void neueRunde(int verlierer){
        this.rechteck = new Rechteck(startPositionX,startPositionY,HOEHE,BREITE);
        if(verlierer==1)
        this.bewegungInYProFrame = -this.bewegungInYProFrame;
    }

    public void darstellen(){
        this.rechteck.darstellenRahmen(this.kollisionsDetektion.spielfeld.getIb());
        this.rechteck.darstellenFuellung(this.kollisionsDetektion.spielfeld.getIb());
    }

}
