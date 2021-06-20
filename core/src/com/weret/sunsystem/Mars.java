package com.weret.sunsystem;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Mars {

    private static final Texture TEXTURE = new Texture("mars.png");
    private static Vector2 position = new Vector2(0, 0);
    private static final float SIZE = 60;
    private double angle = 180;
    private final double DELTA_ANGLE = 1;
    private final float DISTANCE = 250;

    public void render(SpriteBatch batch) {
        batch.draw(TEXTURE, position.x, position.y, SIZE, SIZE);
    }

    public void update() {
        float radians = (float) Math.toRadians(angle);
        float centerX = Sun.POSITION.x + Sun.SIZE / 2 - SIZE / 2;
        float centerY = Sun.POSITION.y + Sun.SIZE / 2 - SIZE / 2;
        float x = (float) (Math.cos(radians) * DISTANCE) + centerX;
        float y = (float) (Math.sin(radians) * DISTANCE) + centerY;
        position.set(x, y);
        angle = angle + DELTA_ANGLE;
    }
}
