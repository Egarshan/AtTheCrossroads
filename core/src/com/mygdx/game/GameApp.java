package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.mainMenu.MenuScreen;
import com.mygdx.game.systemScreens.LoadingScreen;
import com.mygdx.game.systemScreens.SplashScreen;

public class GameApp extends Game {
	public SpriteBatch batch;
	public OrthographicCamera camera;
	public AssetManager assetManager;

	private SplashScreen splashScreen;
	private LoadingScreen loadingScreen;
	private MenuScreen menuScreen;

	public static int SCREEN_WIDTH, SCREEN_HEIGHT;

	@Override
	public void create () {
		Graphics.DisplayMode displayMode = Gdx.graphics.getDisplayMode();
		SCREEN_WIDTH = displayMode.width;
		SCREEN_HEIGHT = displayMode.height;

//		Gdx.graphics.setFullscreenMode(displayMode);
		Gdx.graphics.setResizable(true);

		assetManager = new AssetManager();

		batch = new SpriteBatch();
		camera = new OrthographicCamera(SCREEN_WIDTH, SCREEN_HEIGHT);
		camera.setToOrtho(false);

		splashScreen = new SplashScreen(this);
		loadingScreen = new LoadingScreen(this);
		menuScreen = new MenuScreen(this);

		TypeWriter.initFonts();

		setScreen(splashScreen);
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		this.getScreen().dispose();
		assetManager.dispose();
		batch.dispose();
		TypeWriter.dispose();
	}

	public LoadingScreen getLoadingScreen() {
		return loadingScreen;
	}

	public MenuScreen getMenuScreen() {
		return menuScreen;
	}
}
