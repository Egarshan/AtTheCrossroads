package com.mygdx.game.background;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.GameApp;

public class ScreenBackground {

    private Image[] backgroundImages;
    private Image currentBackground;
    private final GameApp gameApp;

    public ScreenBackground(Image backgroundImage, final GameApp gameApp) {
        this.backgroundImages = new Image[1];
        this.backgroundImages[0] = backgroundImage;
        this.gameApp = gameApp;

        currentBackground = this.backgroundImages[0];
    }

    public ScreenBackground(Image[] backgroundImage, final GameApp gameApp) {
        this.backgroundImages = backgroundImage;
        this.gameApp = gameApp;

        currentBackground = this.backgroundImages[0];
    }

    public void render() {
        currentBackground.draw(gameApp.batch, 1);
    }
}
