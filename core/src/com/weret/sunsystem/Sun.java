package com.weret.sunsystem;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Sun {

    private static final Texture TEXTURE = new Texture("sun.png");
    public static final float SIZE = 350;
    public static final Vector2 POSITION = new Vector2(SunSystem.WIDTH / 2 - SIZE / 2, SunSystem.HEIGHT / 2 - SIZE / 2);
    //позицию солнца располагаем в центре экрана, учитывая что текстура "рисуется" с нижнего левого угла, потому отнимаем половинные размеры
    public void render(SpriteBatch batch) {
        batch.draw(TEXTURE, POSITION.x, POSITION.y, SIZE, SIZE);
    }
}
