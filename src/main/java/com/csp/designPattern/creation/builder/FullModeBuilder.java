package com.csp.designPattern.creation.builder;

import java.util.Collections;

/**
 * @author csp
 * @date 2022/8/22
 */
public class FullModeBuilder extends Builder {

    @Override
    protected void buildMenu() {
        player.setMenu("fullMode-menu");
    }

    @Override
    protected void buildPlayList() {
        player.setPlayList(Collections.singletonList("fullMode-music"));
    }

    @Override
    protected void buildWindow() {
        player.setWindow("fullMode-window");
    }

    @Override
    protected void buildControlBar() {
        player.setControlBar("fullMode-bar");
    }

    @Override
    protected void buildFavoriteList() {
        player.setFavoriteList(Collections.singletonList("fullMode-favorite"));
    }

    @Override
    protected boolean isBuildMenu() {
        return true;
    }

    @Override
    protected boolean isBuildPlayList() {
        return true;
    }

    @Override
    protected boolean isBuildWindow() {
        return true;
    }

    @Override
    protected boolean isBuildControlBar() {
        return true;
    }

    @Override
    protected boolean isBuildFavoriteList() {
        return true;
    }
}
