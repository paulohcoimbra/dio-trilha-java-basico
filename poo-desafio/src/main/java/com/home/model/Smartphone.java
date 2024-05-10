package com.home.model;

public abstract class Smartphone {
    MusicPlayer musicPlayer;
    Phone phone;
    WebBrowser webBrowser;

    public Smartphone(MusicPlayer musicPlayer, Phone phone, WebBrowser webBrowser) {
        this.musicPlayer = musicPlayer;
        this.phone = phone;
        this.webBrowser = webBrowser;
    }
}
