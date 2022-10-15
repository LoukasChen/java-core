package com.csp.designPattern.creation.builder;

import java.util.Collections;

/**
 * @author csp
 * @date 2022/8/22
 */
public class SimpleModeBuilder extends Builder {

    @Override
    protected void buildMenu() {
        player.setMenu("simpleMode-menu");
    }

    @Override
    protected void buildPlayList() {
        player.setPlayList(Collections.singletonList("simpleMode-music"));
    }

    @Override
    protected void buildWindow() {
        player.setWindow("simpleMode-window");
    }

    @Override
    protected void buildControlBar() {
        player.setControlBar("simpleMode-bar");
    }

    @Override
    protected void buildFavoriteList() {
        player.setFavoriteList(Collections.singletonList("simpleMode-favorite"));
    }

    @Override
    protected boolean isBuildMenu() {
        return false;
    }

    @Override
    protected boolean isBuildPlayList() {
        return false;
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
        return false;
    }
}
