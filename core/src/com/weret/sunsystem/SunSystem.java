package com.weret.sunsystem;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class SunSystem extends Game {
    private SpriteBatch batch;
    public static final int WIDTH = 1800;
    public static final int HEIGHT = 900;
    private Earth earth;
    private Sun sun;
    private Mars mars;
    private Moon moon;
    private Stage stage;
    private Boolean isPaused = false;  //нажата ли кнопка пауза

    @Override
    public void create() {
        this.stage = new Stage();
        this.batch = new SpriteBatch();
        this.earth = new Earth();
        this.mars = new Mars();
        this.moon = new Moon();
        this.sun = new Sun();
        ImageButton play = ButtonFactory.getImageButton(new Texture("play.png"), new Vector2(0, 0), new Vector2(100, 100));
        play.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                isPaused = false;
            }
        });
        ImageButton pause = ButtonFactory.getImageButton(new Texture("pause.png"), new Vector2(100, 0), new Vector2(100, 100));
        pause.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                isPaused = true;
            }
        });
        stage.addActor(play);
        stage.addActor(pause);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render() {
        if (!isPaused) {
            update();
        }
        ScreenUtils.clear(0, 0, 0, 1);
        batch.begin();
        sun.render(batch);
        earth.render(batch);
        mars.render(batch);
        moon.render(batch);
        batch.end();
        stage.draw();

    }

    public void update() {
        earth.update();
        mars.update();
        moon.update();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
