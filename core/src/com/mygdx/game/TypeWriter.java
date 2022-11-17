package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class TypeWriter {
    public static BitmapFont mainFont, dialogFont;
    private static final String FONT_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";

    public static void initFonts() {
        FreeTypeFontGenerator mainGen = new FreeTypeFontGenerator(Gdx.files.internal("Fonts/remains.ttf"));
        FreeTypeFontGenerator dialogGen = new FreeTypeFontGenerator(Gdx.files.internal("Fonts/hi_melody.otf"));

        FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();

        params.size = Gdx.graphics.getWidth()/15;
        params.color = Color.ORANGE;
        params.characters = FONT_CHARACTERS;

        mainFont = mainGen.generateFont(params);

        dialogFont = dialogGen.generateFont(params);
    }

    public static void dispose() {
        mainFont.dispose();
        dialogFont.dispose();
    }
}
