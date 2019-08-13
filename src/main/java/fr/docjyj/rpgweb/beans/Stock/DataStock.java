package fr.docjyj.rpgweb.beans.Stock;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class DataStock {

    @SerializedName("Players")
    @Expose
    private List<ObjectStock> players;

    @SerializedName("Mobs")
    @Expose
    private List<ObjectStock> mobs;

    @SerializedName("Weapon")
    @Expose
    private List<ObjectStock> weapon;

    @SerializedName("Objects")
    @Expose
    private List<ObjectStock> object;

    @SerializedName("Rooms")
    @Expose
    private List<RoomStock> room;


    public List<ObjectStock> getMobs() {
        return mobs;
    }

    public void setMobs(List<ObjectStock> mobs) {
        this.mobs = mobs;
    }

    public List<ObjectStock> getPlayers() {
        return players;
    }

    public void setPlayers(List<ObjectStock> players) {
        this.players = players;
    }

    public List<ObjectStock> getWeapon() {
        return weapon;
    }

    public void setWeapon(List<ObjectStock> weapon) {
        this.weapon = weapon;
    }

    public List<ObjectStock> getObject() {
        return object;
    }

    public void setObject(List<ObjectStock> object) {
        this.object = object;
    }

    public List<RoomStock> getRoom() {
        return room;
    }

    public void setRoom(List<RoomStock> room) {
        this.room = room;
    }
}
