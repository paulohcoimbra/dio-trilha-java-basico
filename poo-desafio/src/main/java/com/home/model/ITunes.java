package com.home.model;

public class ITunes implements MusicPlayer{
    @Override
    public void play() {
        System.out.println("Playing music from ITunes...");
    }

    @Override
    public void pause() {
        System.out.println("Pausing ITunes music...");
    }

    @Override
    public void selectMusic() {
        System.out.println("Selecting music on ITunes...");
    }
}
