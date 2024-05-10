package com.home.model;

public class Safari implements WebBrowser{
    @Override
    public void showPage() {
        System.out.println("Showing page on safari...");
    }

    @Override
    public void newTab() {
        System.out.println("Openning new tab on safari...");
    }

    @Override
    public void refresh() {
        System.out.println("Refreshing page on safari...");
    }
}
