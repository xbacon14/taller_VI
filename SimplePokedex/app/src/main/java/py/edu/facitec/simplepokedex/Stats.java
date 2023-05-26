package py.edu.facitec.simplepokedex;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Stats implements Serializable {
    private int hp;
    private int atack;
    private int defense;
    @SerializedName("sp.atk")
    private int spAtk;
    @SerializedName("sp.def")
    private int spDef;
    private int speed;
    private int total;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtack() {
        return atack;
    }

    public void setAtack(int atack) {
        this.atack = atack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpAtk() {
        return spAtk;
    }

    public void setSpAtk(int spAtk) {
        this.spAtk = spAtk;
    }

    public int getSpDef() {
        return spDef;
    }

    public void setSpDef(int spDef) {
        this.spDef = spDef;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Stats(int hp, int atack, int defense, int spAtk, int spDef, int speed, int total) {
        this.hp = hp;
        this.atack = atack;
        this.defense = defense;
        this.spAtk = spAtk;
        this.spDef = spDef;
        this.speed = speed;
        this.total = total;
    }

    public Stats() {
    }

    @Override
    public String toString() {
        return "Stats{" +
                "hp=" + hp +
                ", atack=" + atack +
                ", defense=" + defense +
                ", spAtk=" + spAtk +
                ", spDef=" + spDef +
                ", speed=" + speed +
                ", total=" + total +
                '}';
    }
}
