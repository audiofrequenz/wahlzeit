package org.wahlzeit.model;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RodentPhotoManager extends PhotoManager{

    protected static final RodentPhotoManager instance = new RodentPhotoManager();

    /**
     * RodentPhotoManager constructor implements a new object
     * @methodtype initialization
     */
    public RodentPhotoManager() {
        photoTagCollector = RodentPhotoFactory.getInstance().createPhotoTagCollector();
    }

    /**
     * create a RodentPhoto Object
     * @param rset ResultSet
     * @return RodentPhoto Object
     * @throws SQLException
     * @methodtype command
     */
    protected RodentPhoto createObject(ResultSet rset) throws SQLException {
        return RodentPhotoFactory.getInstance().createRodentPhoto(rset);
    }

    /**
     * create a RodentPhoto File
     * @param file ResultSet
     * @return RodentPhoto Object
     * @throws Exception
     * @methodtype command
     */
    public RodentPhoto createPhoto(File file) throws Exception {
        PhotoId id = PhotoId.getNextId();
        //RodentPhoto result = (RodentPhoto) PhotoUtil.createPhoto(file, id);
        RodentPhoto result = RodentPhotoUtil.createPhoto(file, id);
        addPhoto(result);
        return result;
    }

    /**
     * Factory method for RodentPhotoManager instance
     * @return RodentPhotoManager
     * @methodtype factory
     */
    public static RodentPhotoManager getInstance() {
		return instance;
	}
}
