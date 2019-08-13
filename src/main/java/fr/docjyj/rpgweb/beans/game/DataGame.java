package fr.docjyj.rpgweb.beans.game;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import fr.docjyj.rpgweb.beans.Stock.ObjectStock;

import java.util.List;

public class DataGame {
    @SerializedName("Players")
    @Expose
    private List<EntityGame> players;

    @SerializedName("Mobs")
    @Expose
    private List<EntityGame> mobs;

}
