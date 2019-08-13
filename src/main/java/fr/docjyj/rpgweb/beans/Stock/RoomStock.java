package fr.docjyj.rpgweb.beans.Stock;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RoomStock {
    @SerializedName("Name")
    @Expose
    private String name;

    @SerializedName("Picture")
    @Expose
    private String picture;
}
