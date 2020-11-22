package org.wahlzeit.model;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RodentPhotoManager extends PhotoManager{

    protected static final RodentPhotoManager instance = new RodentPhotoManager();

    public RodentPhotoManager() {
        photoTagCollector = RodentPhotoFactory.getInstance().createPhotoTagCollector();
    }

    protected RodentPhoto createObject(ResultSet rset) throws SQLException {
        return RodentPhotoFactory.getInstance().createRodentPhoto(rset);
    }

    public RodentPhoto createPhoto(File file) throws Exception {
        PhotoId id = PhotoId.getNextId();
        //RodentPhoto result = (RodentPhoto) PhotoUtil.createPhoto(file, id);
        RodentPhoto result = RodentPhotoUtil.createPhoto(file, id);
        addPhoto(result);
        return result;
    }
    
    public static RodentPhotoManager getInstance() {
		return instance;
	}
}
