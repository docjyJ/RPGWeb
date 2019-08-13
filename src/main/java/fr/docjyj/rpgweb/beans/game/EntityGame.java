package fr.docjyj.rpgweb.beans.game;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EntityGame {
    @SerializedName("Type")
    @Expose
    private int type;

    @SerializedName("Health")
    @Expose
    private int health;

    @SerializedName("Weapon")
    @Expose
    private int weapon;

    @SerializedName("Inventory")
    @Expose
    private List<Integer> inventory;

}
