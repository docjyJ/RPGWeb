package fr.docjyj.rpgweb.beans.Stock;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataStock {

    @SerializedName("Players")
    @Expose
    private List<ObjectStock> players;

    @SerializedName("Mobs")
    @Expose
    private List<ObjectStock> mobs;

    @SerializedName("Weapons")
    @Expose
    private List<ObjectStock> weapons;

    @SerializedName("Objects")
    @Expose
    private List<ObjectStock> object;

    @SerializedName("Rooms")
    @Expose
    private List<RoomStock> rooms;

    public List<ObjectStock> getPlayers() {
        return players;
    }

    public void setPlayers(List<ObjectStock> players) {
        this.players = players;
    }

    public List<ObjectStock> getMobs() {
        return mobs;
    }

    public void setMobs(List<ObjectStock> mobs) {
        this.mobs = mobs;
    }

    public List<ObjectStock> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<ObjectStock> weapons) {
        this.weapons = weapons;
    }

    public List<ObjectStock> getObject() {
        return object;
    }

    public void setObject(List<ObjectStock> object) {
        this.object = object;
    }

    public List<RoomStock> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomStock> rooms) {
        this.rooms = rooms;
    }
}
