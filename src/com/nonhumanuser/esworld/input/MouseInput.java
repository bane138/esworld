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
package com.nonhumanuser.esworld.input;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.nonhumanuser.esworld.Game;
import com.nonhumanuser.esworld.enums.GameState;

/**
 * @author dpitzel
 *
 */
public class MouseInput extends MouseAdapter {
	public static int MOUSE_X, MOUSE_Y;
	public static Rectangle MOUSE = new Rectangle(1, 1, 1, 1);
	public static boolean pressed = false;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int mouse = e.getButton();
		Rectangle rect = new Rectangle(e.getX(), e.getY(), 1, 1);
		pressed = true;
		
		if(mouse == MouseEvent.BUTTON1) {
			switch(Game.state) {
			case GAME:
				break;
			case MENU:
				if(rect.intersects(Game.getInstance().getMenu().play)) {
					Game.state = GameState.GAME;
				} else if(rect.intersects(Game.getInstance().getMenu().quit)) {
					System.exit(1);
				}					
				break;
			case OPTIONS:
				break;
			case PAUSE:
				break;
			default:
				break;
			
			}
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		pressed = true;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		pressed = false;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		MOUSE_X = e.getX();
		MOUSE_Y = e.getY();
		MOUSE = new Rectangle(MOUSE_X, MOUSE_Y, 1, 1);
	}
}
