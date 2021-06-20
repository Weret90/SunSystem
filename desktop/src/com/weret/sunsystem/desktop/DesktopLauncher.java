package com.weret.sunsystem.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.weret.sunsystem.SunSystem;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = SunSystem.WIDTH;
		config.height = SunSystem.HEIGHT;
		new LwjglApplication(new SunSystem(), config);
	}
}
