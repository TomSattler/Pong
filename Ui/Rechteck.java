package Ui;

import Util.Interaktionsbrett;

public class Rechteck {

    private int x;
    private int y;
    private int hoehe;
    private int breite;

    public Rechteck(int x, int y, int hoehe, int breite) {
        setBreite(breite);
        setHoehe(hoehe);
        setY(y);
        setX(x);
    }

    public void verschiebeVertikal(int faktor){
        this.y=this.y+faktor;
    }

    public void verschiebeNach(int x, int y){
        this.x=x;
        this.y=y;
    }

    public boolean ueberschneidet(Rechteck o){
        if(o.getY() >= this.getY() && o.getY() + o.hoehe() <= this.getY() + this.hoehe()||o.getY() <= this.getY()&&o.getY() + o.hoehe() >= this.getY() + this.hoehe()){
            if(o.getX() >= this.getX() && o.getX() + o.breite() <= this.getX() + this.breite()||o.getX() <= this.getX()&&o.getX() + o.breite() >= this.getX() + this.breite()) {
                return true;
            }
        }
        return false;
    }

    public void darstellenRahmen(Interaktionsbrett ib){
        ib.neuesRechteck(this.x,this.y, this.breite,this.hoehe);
    }

    public void darstellenFuellung(Interaktionsbrett ib){
        for(int i = 0; i < hoehe; i++) {
            ib.neueLinie(this.x, this.y+i, this.x +breite, this.y + i);
        }
    }


    public int hoehe(){
        return this.hoehe;
    }
    public int breite(){
        return this.breite;
    }
    public int oben(){
        return this.getY();
    }
    public int unten(){
        return this.getY()+hoehe;
    }
    public int links(){
        return this.getX();
    }
    public int rechts(){
        return this.getY()+ breite;
    }
    public void setX(int x) {
        if(x>0)
            this.x=x;
    }
    public void setY(int y) {
        if(y>0)
            this.y = y;
    }
    public int mitteInX(){
        return (this.breite()+this.x)/2;
    }
    public int mitteInY(){
        return (this.hoehe()+this.y)/2;
    }
    public void setHoehe(int hoehe) {
        if(hoehe>0){
            this.hoehe = hoehe;
        }
    }
    public void setBreite(int breite) {
        if(breite>0){
            this.breite = breite;
        }
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}
