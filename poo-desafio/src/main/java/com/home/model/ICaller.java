package com.home.model;

public class ICaller implements Phone{
    @Override
    public void call() {
        System.out.println("Calling from ICaller...");
    }

    @Override
    public void answer() {
        System.out.println("Answering from ICaller...");
    }

    @Override
    public void initVoiceMail() {
        System.out.println("Initializing Voice Mail from ICaller...");
    }
}
