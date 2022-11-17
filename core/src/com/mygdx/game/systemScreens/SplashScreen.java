package com.mygdx.game.systemScreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.GameApp;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class SplashScreen implements Screen {

    private final GameApp gameApp;
    private Stage stage;

    private Image logoImg;

    public SplashScreen(final GameApp gameApp) {
        this.gameApp = gameApp;
        this.stage = new Stage(new ExtendViewport(GameApp.SCREEN_WIDTH, GameApp.SCREEN_HEIGHT, gameApp.camera));
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        Runnable transitionToMenu = new Runnable() {
            @Override
            public void run() {
                gameApp.setScreen(gameApp.getMenuScreen());
                disposeSplashScreen();
            }
        };

        Texture logoTexture = new Texture(Gdx.files.internal("LaunchScreen/company_logo.jpg"));
        logoImg = new Image(logoTexture);
        logoImg.setOrigin(logoImg.getWidth() / 2, logoImg.getHeight() / 2);

        stage.addActor(logoImg);

        logoImg.setPosition(stage.getWidth() / 2 - logoImg.getWidth() /2 , stage.getHeight() / 2 - logoImg.getHeight() /2);

        logoImg.addAction(sequence(alpha(0f), scaleTo(1.5f, 1.5f),
                parallel(fadeIn(0.1f, Interpolation.smooth), scaleTo(2f, 2f, 0.1f, Interpolation.smooth)),
                delay(1f), fadeOut(0.1f, Interpolation.smooth), run(transitionToMenu)));
        // duration must to be 3f

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);

        update(delta);
        stage.draw();
    }

    public void update(float delta) {
        stage.act(delta);
        if (!gameApp.assetManager.update())
            gameApp.assetManager.update();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, false);
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

    private void disposeSplashScreen() {
        this.dispose();
    }
}
