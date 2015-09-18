package org.foodie.server.service;

import java.io.Serializable;
import java.util.Date;
import java.util.Properties;

/**
 * A document from an archive managed by {@link IArchiveService}.
 * 
 * @author Daniel Murygin <daniel.murygin[at]gmail[dot]com>
 * Version for Feedme
 * @author wangfei 
 */
public class Photo extends PhotoMetadata implements Serializable {

    private static final long serialVersionUID = 2004955454853853315L;
    
    private byte[] fileData;
    
    public Photo( byte[] fileData, String fileName, Date documentDate, String personName) {
        super(fileName, documentDate, personName);
        this.fileData = fileData;
    }

    public Photo(Properties properties) {
        super(properties);
    }
    
    public Photo(PhotoMetadata metadata) {
        super(metadata.getUuid(), metadata.getFileName(), metadata.getDocumentDate(), metadata.getPersonName());
    }

    public byte[] getFileData() {
        return fileData;
    }
    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
    
    public PhotoMetadata getMetadata() {
        return new PhotoMetadata(getUuid(), getFileName(), getDocumentDate(), getPersonName());
    }
    
}
