package com.weret.sunsystem;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Moon {

    private static final Texture TEXTURE = new Texture("moon.png");
    private static Vector2 position = new Vector2(0, 0);
    private static final float SIZE = 40;
    private double angle = 90;
    private final double DELTA_ANGLE = 0.7;
    private final float DISTANCE = 100;

    public void render(SpriteBatch batch) {
        batch.draw(TEXTURE, position.x, position.y, SIZE, SIZE);
    }

    public void update() {
        float radians = (float) Math.toRadians(angle);
        float centerX = Earth.position.x + Earth.SIZE / 2 - SIZE / 2;
        float centerY = Earth.position.y + Earth.SIZE / 2 - SIZE / 2;
        float x = (float) (Math.cos(radians) * DISTANCE) + centerX;
        float y = (float) (Math.sin(radians) * DISTANCE) + centerY;
        position.set(x, y);
        angle = angle + DELTA_ANGLE;
    }
}
