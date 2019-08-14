package fr.docjyj.rpgweb.beans.Stock;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RoomStock {
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

    @SerializedName("X")
    @Expose
    private int x;

    @SerializedName("Y")
    @Expose
    private int y;

    @SerializedName("TX")
    @Expose
    private int tX;

    @SerializedName("TY")
    @Expose
    private int tY;

    @SerializedName("Mobs")
    @Expose
    private List<Integer> mobs;

    @SerializedName("Weapons")
    @Expose
    private List<Integer> weapons;

    @SerializedName("Objects")
    @Expose
    private List<Integer> objects;

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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int gettX() {
        return tX;
    }

    public void settX(int tX) {
        this.tX = tX;
    }

    public int gettY() {
        return tY;
    }

    public void settY(int tY) {
        this.tY = tY;
    }

    public List<Integer> getMobs() {
        return mobs;
    }

    public void setMobs(List<Integer> mobs) {
        this.mobs = mobs;
    }

    public List<Integer> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Integer> weapons) {
        this.weapons = weapons;
    }

    public List<Integer> getObjects() {
        return objects;
    }

    public void setObjects(List<Integer> objects) {
        this.objects = objects;
    }
}
