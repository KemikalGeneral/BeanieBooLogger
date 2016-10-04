package com.endorphinapps.kemikal.beanieboologger;

/**
 * Created by KeMiKaL on 20/09/2016.
 */

/**
 * Item class containing a constructors, getters and setters
 */
/**
 * id
 * name
 * image
 */

public class Item {

    int _id;
    private String name;
    private Integer image;

    /** Constructors **/
    public Item() {
    }

    public Item(String name, Integer image) {
        this.name = name;
        this.image = image;
    }

    public Item(Integer _id, String name, Integer image) {
        this._id = _id;
        this.name= name;
        this.image = image;
    }

    /** Getters and Setters **/
    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Item{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", image=" + image +
                '}';
    }
}
