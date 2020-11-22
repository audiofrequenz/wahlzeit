package org.wahlzeit.model;

import java.awt.Image;
import java.io.File;

public class RodentPhotoUtil extends PhotoUtil {

	public static RodentPhoto createPhoto(File source, PhotoId id) throws Exception {
		RodentPhoto result = RodentPhotoFactory.getInstance().createRodentPhoto(id);
		
		Image sourceImage = createImageFiles(source, id);

		int sourceWidth = sourceImage.getWidth(null);
		int sourceHeight = sourceImage.getHeight(null);
		result.setWidthAndHeight(sourceWidth, sourceHeight);

		return result;
	}    
}
