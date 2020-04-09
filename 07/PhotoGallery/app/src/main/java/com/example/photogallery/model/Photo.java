
package com.example.photogallery.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Entity
public class Photo {

    @PrimaryKey
    @NonNull
    private String id;
    private String owner;
    private String secret;
    private String server;
    private Integer farm;
    private String title;
    private Integer ispublic;
    private Integer isfriend;
    private Integer isfamily;
    //private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */

    public Photo() {
    }

    public Photo(String id, String owner, String secret, String server, Integer farm, String title, Integer ispublic, Integer isfriend, Integer isfamily) {
        super();
        this.id = id;
        this.owner = owner;
        this.secret = secret;
        this.server = server;
        this.farm = farm;
        this.title = title;
        this.ispublic = ispublic;
        this.isfriend = isfriend;
        this.isfamily = isfamily;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Integer getFarm() {
        return farm;
    }

    public void setFarm(Integer farm) {
        this.farm = farm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIspublic() {
        return ispublic;
    }

    public void setIspublic(Integer ispublic) {
        this.ispublic = ispublic;
    }

    public Integer getIsfriend() {
        return isfriend;
    }

    public void setIsfriend(Integer isfriend) {
        this.isfriend = isfriend;
    }

    public Integer getIsfamily() {
        return isfamily;
    }

    public void setIsfamily(Integer isfamily) {
        this.isfamily = isfamily;
    }

    /*public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return id.equals(photo.id) &&
                Objects.equals(owner, photo.owner) &&
                Objects.equals(secret, photo.secret) &&
                Objects.equals(server, photo.server) &&
                Objects.equals(farm, photo.farm) &&
                title.equals(photo.title) &&
                Objects.equals(ispublic, photo.ispublic) &&
                Objects.equals(isfriend, photo.isfriend) &&
                Objects.equals(isfamily, photo.isfamily);
                //Objects.equals(additionalProperties, photo.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, owner, secret, server, farm, title, ispublic, isfriend, isfamily);
    }
}
