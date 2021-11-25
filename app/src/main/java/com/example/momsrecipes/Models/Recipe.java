package com.example.momsrecipes.Models;

public class Recipe {
    String image;
    String recipeName;
    String url;

    public Recipe(String image, String recipeName, String url) {
        this.image = image;
        this.recipeName = recipeName;
        this.url = url;
    }

    public Recipe() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
