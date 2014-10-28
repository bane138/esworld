package com.nonhumanuser.esworld.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.nonhumanuser.esworld.Game;
import com.nonhumanuser.esworld.libs.Resource;
import com.nonhumanuser.esworld.utils.Images;

public class Menu {
	
	public Rectangle play, options, quit;
	//private static int centerX = Game.WIDTH / 2;
	//private static int centerY = Game.HEIGHT / 2;
	
	public Menu() {
		int fillerY = 150;
		play = new Rectangle(Resource.CENTER_X - 100, fillerY, 200, 50);
		options = new Rectangle(Resource.CENTER_X - 100, fillerY+=60, 200, 50);
		quit = new Rectangle(Resource.CENTER_X - 100, fillerY+=60, 200, 50);
	}
	
	public void drawButton(Graphics g, Rectangle rect, String text, int offset) {
		Font idlewild = new Font("idolwild", Font.PLAIN, 45);
		g.setFont(idlewild);
		g.setColor(Color.GREEN);
		g.drawRect(rect.x, rect.y, rect.width, rect.height);
		g.drawString(text, rect.x + offset, rect.y + 38);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.drawImage(Images.title, 128, 10, null);
		drawButton(g, play, "Play", 55);
		drawButton(g, options, "Options",20);
		drawButton(g, quit, "Quit", 55);
	}
}
