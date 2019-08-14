package fr.docjyj.rpgweb.beans.Stock;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ObjectStock {
    @SerializedName("Name")
    @Expose
    private String name;

    @SerializedName("Picture")
    @Expose
    private String picture;

    @SerializedName("Description")
    @Expose
    private String description;

    @SerializedName("Color")
    @Expose
    private String color;

    @SerializedName("Health")
    @Expose
    private int health;

    @SerializedName("Strength")
    @Expose
    private int srength;

    @SerializedName("Agility")
    @Expose
    private int agility;

    @SerializedName("Focus")
    @Expose
    private int focus;

    @SerializedName("Attack")
    @Expose
    private int attack;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSrength() {
        return srength;
    }

    public void setSrength(int srength) {
        this.srength = srength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getFocus() {
        return focus;
    }

    public void setFocus(int focus) {
        this.focus = focus;
    }
}
