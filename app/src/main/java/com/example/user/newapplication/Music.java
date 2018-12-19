package com.example.user.newapplication;

public class Music {

    private String songName;
    private String songId;
    private String songImage;

    public Music(){

    }
    public Music (String songName, String songId, String songImage){

        this.songImage = songImage;
        this.songId = songId;
        this.songName = songName;
    }

    public String getSongId() {
        return songId;
    }

    public String getSongImage() {
        return songImage;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public void setSongImage(String songImage) {
        this.songImage = songImage;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }
}
