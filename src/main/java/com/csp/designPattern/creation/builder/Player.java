package com.csp.designPattern.creation.builder;

import java.util.List;

/**
 * @author csp
 * @date 2022/8/22
 */
public class Player {

    private String menu;

    private List<String> playList;

    private String window;

    private String controlBar;

    private List<String> favoriteList;

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public List<String> getPlayList() {
        return playList;
    }

    public void setPlayList(List<String> playList) {
        this.playList = playList;
    }

    public String getWindow() {
        return window;
    }

    public void setWindow(String window) {
        this.window = window;
    }

    public String getControlBar() {
        return controlBar;
    }

    public void setControlBar(String controlBar) {
        this.controlBar = controlBar;
    }

    public List<String> getFavoriteList() {
        return favoriteList;
    }

    public void setFavoriteList(List<String> favoriteList) {
        this.favoriteList = favoriteList;
    }

    @Override
    public String toString() {
        return "Player{" +
                "menu='" + menu + '\'' +
                ", playList=" + playList +
                ", window='" + window + '\'' +
                ", controlBar='" + controlBar + '\'' +
                ", favoriteList=" + favoriteList +
                '}';
    }
}
