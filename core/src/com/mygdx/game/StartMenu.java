package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class StartMenu implements Screen {
    private Viewport viewport;
    private Stage stage;
    Texture backGround2;
    TextureRegion backGround;
    private Sound pikaHappy;

    private MyGdxGame game;

    public StartMenu(MyGdxGame game){
        pikaHappy = Gdx.audio.newSound(Gdx.files.internal("Pika Pika Happy.mp3"));
        pikaHappy.play();

        this.game = game;
        viewport = new FitViewport(800, 480, new OrthographicCamera());
        stage = new Stage(viewport, game.batch);
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Pokemon Solid.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 20;
        BitmapFont font = generator.generateFont(parameter);
        generator.dispose();

        backGround2 = new Texture(Gdx.files.internal("download.png"));
        backGround = new TextureRegion(backGround2, 0, 0, 1920, 1080);

        Table table = new Table();
        table.center();
        table.setFillParent(true);

        Label gameOverLabel = new Label("Help Pikachu catch the Pokeballs!", new Label.LabelStyle(font, Color.BLACK));
        Label playAgainLabel = new Label("Click to Play! Don't miss 3!", new Label.LabelStyle(font, Color.BLACK));

        table.add(gameOverLabel).expandX();
        table.row();
        table.add(playAgainLabel).expandX().padTop(10f);

        stage.addActor(table);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(Gdx.input.justTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(backGround, 0, 0, 800, 480);
        game.batch.end();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

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
        backGround2.dispose();
        pikaHappy.dispose();
    }
}
