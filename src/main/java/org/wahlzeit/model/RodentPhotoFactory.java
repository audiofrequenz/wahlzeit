package org.wahlzeit.model;

import org.wahlzeit.services.SysLog;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RodentPhotoFactory extends PhotoFactory {

    public RodentPhotoFactory(){
        super();
    }
    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    private static RodentPhotoFactory instance = null;

    /**
     * Public singleton access method.
     */
    public static synchronized RodentPhotoFactory getInstance() {
        if (instance == null) {
            SysLog.logSysInfo("setting generic RodentPhotoFactory");
            setInstance(new RodentPhotoFactory());
        }

        return instance;
    }

    /**
     * Method to set the singleton instance of RodentPhotoFactory.
     */
    protected static synchronized void setInstance(RodentPhotoFactory rodentPhotoFactory) {
        if (instance != null) {
            throw new IllegalStateException("attempt to initialize RodentPhotoFactory twice");
        }

        instance = rodentPhotoFactory;
    }

    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    public static void initialize() {
        getInstance(); // drops result due to getInstance() side-effects
    }


    /**
     * @methodtype factory
     */
    public RodentPhoto createRodentPhoto() {
        return new RodentPhoto();
    }

    /**
     *
     */
    public RodentPhoto createRodentPhoto(PhotoId id) {
        return new RodentPhoto(id);
    }

    /**
     *
     */
    public RodentPhoto createRodentPhoto(ResultSet rs) throws SQLException {
        return new RodentPhoto(rs);
    }

    /**
     *
     */
    public PhotoFilter createPhotoFilter() {
        return new PhotoFilter();
    }

    /**
     *
     */
    public PhotoTagCollector createPhotoTagCollector() {
        return new PhotoTagCollector();
    }
}
