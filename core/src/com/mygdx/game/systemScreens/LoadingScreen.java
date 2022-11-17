package com.mygdx.game.systemScreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.GameApp;

public class LoadingScreen implements Screen {

    private GameApp gameApp;
    private Image loadingImage;
    private Texture loadingTexture;
    private Stage stage;
    private float angleAmount;

    public LoadingScreen(final GameApp gameApp) {
        this.gameApp = gameApp;
        this.stage = new Stage(new ExtendViewport(GameApp.SCREEN_WIDTH, GameApp.SCREEN_HEIGHT, gameApp.camera));
    }

    @Override
    public void show() {
        loadingTexture = new Texture(Gdx.files.internal("LoadingScreen/loading_icon.png"));
        loadingImage = new Image(loadingTexture);

        loadingImage.setSize(GameApp.SCREEN_WIDTH / 8f, GameApp.SCREEN_WIDTH / 8f + 48f);
        loadingImage.setPosition(GameApp.SCREEN_WIDTH - loadingImage.getWidth() * 1.5f, 20f);

//        loadAssets();
        stage.addActor(loadingImage);

        angleAmount = 0;
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);

        update(delta);
        loadingImage.setPosition(loadingImage.getX() + (float) Math.cos(angleAmount), loadingImage.getY() + (float) Math.sin(angleAmount));
        stage.draw();
    }

    private void update(float delta) {
//        if (gameApp.assetManager.update()) {
//            gameApp.setScreen(new SplashScreen(gameApp));
//            this.dispose();
//        }
        angleAmount += delta * 3;
        stage.act(delta);
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    private void loadAssets() {
//        gameApp.assetManager.load("LaunchScreen/company_logo.jpg", Texture.class);
    }
}
