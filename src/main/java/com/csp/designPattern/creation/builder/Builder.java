package com.csp.designPattern.creation.builder;

/**
 * @author csp
 * @date 2022/8/22
 */
public abstract class Builder {

    protected Player player = new Player();

    protected abstract void buildMenu();

    protected abstract void buildPlayList();

    protected abstract void buildWindow();

    protected abstract void buildControlBar();

    protected abstract void buildFavoriteList();

    protected boolean isBuildMenu() {
        return false;
    }

    protected boolean isBuildPlayList() {
        return false;
    }

    protected boolean isBuildWindow() {
        return false;
    }

    protected boolean isBuildControlBar() {
        return false;
    }

    protected boolean isBuildFavoriteList() {
        return false;
    }

    public Player build() {
        if (isBuildMenu()) {
            this.buildMenu();
        }
        if (isBuildPlayList()) {
            this.buildPlayList();
        }
        if (isBuildWindow()) {
            this.buildWindow();
        }
        if (isBuildControlBar()) {
            this.buildControlBar();
        }
        if (isBuildFavoriteList()) {
            this.buildFavoriteList();
        }
        return player;
    }

}
