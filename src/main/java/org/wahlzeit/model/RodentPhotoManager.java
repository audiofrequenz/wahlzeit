package org.wahlzeit.model;

import java.io.*;
import java.sql.*;
import java.util.*;

import org.wahlzeit.main.*;
import org.wahlzeit.services.*;

public class RodentPhotoManager extends PhotoManager{

    public RodentPhotoManager() {
        photoTagCollector = PhotoFactory.getInstance().createPhotoTagCollector();
    }

    protected RodentPhoto createObject(ResultSet rset) throws SQLException {
        return RodentPhotoFactory.getInstance().createRodentPhoto(rset);
    }

//    public RodentPhoto createPhoto(File file) throws Exception {
//        PhotoId id = PhotoId.getNextId();
//        Photo result = PhotoUtil.createPhoto(file, id);
//        super.addPhoto(result);
//        return result;
//    }
}
