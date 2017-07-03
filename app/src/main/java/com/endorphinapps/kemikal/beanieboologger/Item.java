package com.endorphinapps.kemikal.beanieboologger;

/**
 * Created by KeMiKaL on 20/09/2016.
 */
public class Item {

    int _id;
    private String name;
    private Integer image;
    private String birthday;
    private Integer isOwned;

    public Item() {
    }

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getIsOwned() {
        return isOwned;
    }

    public void setIsOwned(Integer isOwned) {
        this.isOwned = isOwned;
    }

    @Override
    public String toString() {
        return "Item{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", image=" + image +
                ", birthday='" + birthday + '\'' +
                ", isOwned=" + isOwned +
                '}';
    }
}
