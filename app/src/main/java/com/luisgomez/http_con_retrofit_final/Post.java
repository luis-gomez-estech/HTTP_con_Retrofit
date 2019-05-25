package com.luisgomez.http_con_retrofit_final;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {


    // Aqui creamos los campos que tiene la appi que vamos a ller, en este caso, es la de post, y sus campos son, userId, id, title y body

    @SerializedName("userId")
    //@Expose
    private Integer userId;

    @SerializedName("id")

    private Integer id;

    @SerializedName("title")

    private String title;

    @SerializedName("body")

    private String body;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String desc) {
        this.body = desc;
    }

    //No necesitamos el toString esta vez
}
