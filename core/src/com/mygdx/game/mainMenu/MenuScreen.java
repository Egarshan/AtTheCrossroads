package com.mygdx.game.mainMenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.GameApp;
import com.mygdx.game.TypeWriter;
import com.mygdx.game.background.ScreenBackground;

public class MenuScreen implements Screen {

    private final GameApp gameApp;
    private ScreenBackground background;

    private Texture backgroundTexture;
    private Image backgroundImage;
    private Stage stage;
    private Skin skin;

    private TextButton buttonExit, buttonStart;

    public MenuScreen(final GameApp gameApp) {
        this.gameApp = gameApp;
        this.stage = new Stage(new ExtendViewport(GameApp.SCREEN_WIDTH, GameApp.SCREEN_HEIGHT, gameApp.camera));

        gameApp.assetManager.load("SkinTest/uiskin.atlas", TextureAtlas.class);
    }

    @Override
    public void show() {
        loadAssets();

        backgroundImage = new Image(backgroundTexture);
        backgroundImage.setSize(GameApp.SCREEN_WIDTH, GameApp.SCREEN_HEIGHT);

        background = new ScreenBackground(backgroundImage, gameApp);

        Gdx.input.setInputProcessor(stage);

        this.skin = new Skin();
        this.skin.addRegions(gameApp.assetManager.get("SkinTest/uiskin.atlas", TextureAtlas.class));
        this.skin.add("default-font", TypeWriter.mainFont);
        this.skin.load(Gdx.files.internal("SkinTest/uiskin.json"));

        initUI();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);

        update(delta);

        gameApp.batch.begin();
        background.render();
        gameApp.batch.end();
        stage.draw();
    }

    private void update(float delta) {
        stage.act(delta);
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
        gameApp.batch.setProjectionMatrix(gameApp.camera.combined);
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
        backgroundTexture = new Texture(Gdx.files.internal("MainMenu/background.png"));
    }

    private void initUI() {
        buttonStart = new TextButton("Start", skin, "default");
        buttonStart.setPosition(110, 360);
        buttonStart.setSize(280, 60);

        buttonExit = new TextButton("Exit", skin, "default");
        buttonExit.setPosition(110, 260);
        buttonExit.setSize(280, 60);

        buttonExit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });

        stage.addActor(buttonExit);
        stage.addActor(buttonStart);
    }
}
