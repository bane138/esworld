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
package com.nonhumanuser.esworld.gfx;

import java.awt.Color;
import java.awt.Graphics;

import com.nonhumanuser.esworld.Game;
import com.nonhumanuser.esworld.screens.Menu;

/**
 * @author dpitzel
 *
 */
public class Renderer {

	//private static Game game = Game.getInstance();
	
	public void renderBackground(Graphics g) {
		switch(Game.state) {
		case GAME:
			break;
		case MENU:
			Game.getInstance().getMenu().render(g);
			break;
		case OPTIONS:
			break;
		case PAUSE:
			break;
		default:
			g.setColor(Color.RED);
			g.drawString("Unknown Game State", 150, 150);
		}
		Game.getInstance().getMenu().render(g);
	}
	
	public void renderForeground(Graphics g) {
		
	}
}
