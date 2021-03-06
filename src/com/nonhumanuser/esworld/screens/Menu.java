package com.nonhumanuser.esworld.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.nonhumanuser.esworld.Game;
import com.nonhumanuser.esworld.libs.Resource;
import com.nonhumanuser.esworld.utils.Button;
import com.nonhumanuser.esworld.utils.Images;

public class Menu {
	
	public Button play, options, quit;
	//private static int centerX = Game.WIDTH / 2;
	//private static int centerY = Game.HEIGHT / 2;
	
	public Menu() {
		int fillerY = 150;
		play = new Button(Resource.CENTER_X - 100, fillerY, 200, 50).setText("Play");
		options = new Button(Resource.CENTER_X - 100, fillerY+=60, 200, 50).setText("Options");
		quit = new Button(Resource.CENTER_X - 100, fillerY+=60, 200, 50).setText("Quit");
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.drawImage(Images.title, 128, 10, null);

		Font idlewild = new Font("idolwild", Font.PLAIN, 45);
		g.setFont(idlewild);
		
		play.drawButton(g, 55);
		options.drawButton(g, 20);
		quit.drawButton(g, 55);
	}
}
