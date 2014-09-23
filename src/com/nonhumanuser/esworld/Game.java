/**
 * This file is part of EsWorld.

    EsWorld is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    EsWorld is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with EsWorld.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.nonhumanuser.esworld;

import java.awt.Canvas;

import javax.swing.JFrame;

/**
 * @author dpitzel
 *
 */
public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 5197888200994473611L;
	
	public static final int WIDTH = 640;
	public static final int HEIGHT = WIDTH / 4 * 3;
	public static final String TITLE = "E's World";
	private static Game game = new Game();
	
	private boolean running = false;
	private Thread thread;
	
	public void init() {
		
	}
	
	public void tick() {
		
	}
	
	public void render() {
		
	}
	
	@Override
	public void run() {
		init();
		long lastTime = System.nanoTime();
		final double numTicks = 60.0;
		double n = 1000000000 / numTicks;
		double delta = 0;
		int frames = 0;
		int ticks = 0;
		long timer = System.currentTimeMillis();
		
		while(running) {
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / n;
			lastTime = currentTime;
			
			if(delta >= 1) {
				tick();
				ticks++;
				delta--;
			}
			
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("Ticks: " + ticks + ", FPS: " + frames);
				ticks = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	public static void main(String args[]) {
		JFrame frame = new JFrame(TITLE);
		frame.add(game);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
		game.start();
	}
	
	private synchronized void start() {
		if(running) {
			return;
		} else {
			running = true;
		}
		thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void stop() {
		if(!running) {
			return;
		} else {
			running = false;
		}
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.exit(1);
	}

}
