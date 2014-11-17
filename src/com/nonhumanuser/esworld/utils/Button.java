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
package com.nonhumanuser.esworld.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import com.nonhumanuser.esworld.input.MouseInput;

/**
 * @author dpitzel
 *
 */
public class Button extends Rectangle {
	
	private String text;
	
	/**
	 * Creates a default button/rectangle
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public Button() {
		super();
	}

	/**
	 * @param r
	 */
	public Button(Rectangle r) {
		super(r);
	}

	/**
	 * @param p
	 */
	public Button(Point p) {
		super(p);
	}

	/**
	 * @param d
	 */
	public Button(Dimension d) {
		super(d);
	}

	/**
	 * @param width
	 * @param height
	 */
	public Button(int width, int height) {
		super(width, height);
	}

	/**
	 * @param p
	 * @param d
	 */
	public Button(Point p, Dimension d) {
		super(p, d);
	}

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Button(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	public Button setText(String text) {
		this.text = text;
		return this;
	}
	
	public void drawButton(Graphics g, int offset) {
		int xx = x + offset;
		int yy = y + 38;
		if(MouseInput.MOUSE.intersects(this)) {
			g.setColor(Color.YELLOW);
		} else {
			g.setColor(Color.GREEN);
		}
		if(!MouseInput.pressed && MouseInput.MOUSE.intersects(this)) {
			g.drawRect(x, y, width, height);			
		} else if(MouseInput.pressed && MouseInput.MOUSE.intersects(this)) {
			g.fillRect(x, y, width, height);
		} else {
			g.drawRect(x, y, width, height);
		}
		g.setColor(Color.RED);
		g.drawString(text, xx, yy);
	}

}
