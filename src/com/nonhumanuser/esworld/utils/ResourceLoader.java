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

import java.io.IOException;

import com.nonhumanuser.esworld.libs.Fonts;
import com.nonhumanuser.esworld.libs.Resource;

/**
 * @author dpitzel
 *
 */
public class ResourceLoader {
	private static BufferedImageLoader imageLoader = new BufferedImageLoader();
	
	public static void loadImages() {
		try {
			Images.title = imageLoader.loadImage(Resource.SPRITE_LOCATION + "title.png");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadFonts() {
		Fonts.addFont(new Fonts("idolwild.ttf"));
	}
}
