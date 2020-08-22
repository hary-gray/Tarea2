package com.harymen.app.listademascotas;

public class Fotos {
    private int image;
    private int likes;

    public Fotos(int image, int likes) {
        this.image = image;
        this.likes = likes;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
