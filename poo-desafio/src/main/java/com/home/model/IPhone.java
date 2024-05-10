package com.home.model;

public class IPhone extends Smartphone{

    private final String  model;

    public IPhone(String model) {
        super(new ITunes(), new ICaller(), new Safari());
        this.model = model;
    }

    public String getOptions() {
        StringBuilder builder = new StringBuilder();

        builder.append("ITunes\n");
        builder.append("1.1 Play Music\n");
        builder.append("1.2 Pause Music\n");
        builder.append("1.3 Select Music\n\n");

        builder.append("ICaller\n");
        builder.append("2.1 Call\n");
        builder.append("2.2 Answer\n");
        builder.append("2.3 Init Voice Mail\n\n");

        builder.append("Safari\n");
        builder.append("3.1 Show Page\n");
        builder.append("3.2 New Tab\n");
        builder.append("3.3 Refresh\n\n");

        builder.append("0. Exit\n");

        return builder.toString();
    }

    public void activeOption(String option) {
        switch (option) {
            case "1.1":
                super.musicPlayer.play();
                break;
            case "1.2":
                super.musicPlayer.pause();
                break;
            case "1.3":
                super.musicPlayer.selectMusic();
                break;
            case "2.1":
                super.phone.call();
                break;
            case "2.2":
                super.phone.answer();
                break;
            case "2.3":
                super.phone.initVoiceMail();
                break;
            case "3.1":
                super.webBrowser.showPage();
                break;
            case "3.2":
                super.webBrowser.newTab();
                break;
            case "3.3":
                super.webBrowser.refresh();
                break;
            default:
                System.out.println("Option not found, try again!");
                break;
        }
    }


    @Override
    public String toString() {
        return "IPhone " + model;
    }
}
