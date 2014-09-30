package com.nonhumanuser.esworld.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.nonhumanuser.esworld.Game;

public class Menu {
	
	private static Rectangle play, options, quit;
	private static int centerX = Game.WIDTH / 2;
	private static int centerY = Game.HEIGHT / 2;
	
	public static void create() {
		int fillerY = 150;
		play = new Rectangle(centerX - 100, fillerY, 200, 50);
		options = new Rectangle(centerX - 100, fillerY+=60, 200, 50);
		quit = new Rectangle(centerX - 100, fillerY+=60, 200, 50);
	}
	
	public static void drawButton(Graphics g, Rectangle rect, String text, int offset) {
		Font tempFont = new Font("Arial", Font.BOLD, 45);
		g.setFont(tempFont);
		g.setColor(Color.GREEN);
		g.drawRect(rect.x, rect.y, rect.width, rect.height);
		g.drawString(text, rect.x + offset, rect.y + 38);
	}
	
	public static void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		drawButton(g, play, "Play", 45);
		drawButton(g, options, "Options",3);
		drawButton(g, quit, "Quit", 45);
	}
}
