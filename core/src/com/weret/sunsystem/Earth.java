package com.weret.sunsystem;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Earth {

    private static final Texture TEXTURE = new Texture("earth.png");
    public static Vector2 position = new Vector2(0, 0);
    public static final float SIZE = 100;
    private double angle = 0; //угол с которого начнет движение земля относительно солнца
    private final double DELTA_ANGLE = 0.5; //угол на которую смещается земля относительно солнца каждый кадр, по сути - скорость вращения
    private final float DISTANCE = 350; //расстояние от земли до солнца

    public void render(SpriteBatch batch) {
        batch.draw(TEXTURE, position.x, position.y, SIZE, SIZE);
    }

    public void update() {
        float radians = (float) Math.toRadians(angle);
        float centerX = Sun.POSITION.x + Sun.SIZE / 2 - SIZE / 2;
        float centerY = Sun.POSITION.y + Sun.SIZE / 2 - SIZE / 2;
        //находим координаты точки вокруг которой будет вращаться земля (центр солнца)
        //в координатах учитываем, что текстура рисуется с нижнего левого угла поэтому корректируем координаты прибавляя или отнимая половинные размеры текстур
        float x = (float) (Math.cos(radians) * DISTANCE) + centerX;
        float y = (float) (Math.sin(radians) * DISTANCE) + centerY;
        position.set(x, y);
        angle = angle + DELTA_ANGLE; //изменяем угол, чтобы земля двигалась
    }
}
