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
package com.nonhumanuser.esworld.libs;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.ArrayList;

/**
 * @author dpitzel
 *
 */
public class Fonts {
	
	private static ArrayList<Fonts> fontList = new ArrayList<Fonts>();
	
	private static String fontPath;
	
	public Fonts(String filePath) {
		Fonts.fontPath = Resource.FONT_LOCATION + filePath;
		registerFont();
	}
	
	private void registerFont() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		
		try {
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addFont(Fonts font) {
		fontList.add(font);
	}
}
