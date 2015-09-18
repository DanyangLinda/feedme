package org.foodie.server.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.foodie.server.dao.PhotoFileSystemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * A service to save, find and get documents from an archive. 
 * 
 * @author Daniel Murygin <daniel.murygin[at]gmail[dot]com>
 * Version for feed me
 * @author wangfei
 * 
 */
@Service("archiveService")
public class PhotoService implements  Serializable {

    private static final long serialVersionUID = 8119784722798361327L;
    
    @Autowired
    private PhotoFileSystemDao DocumentDao = new PhotoFileSystemDao();

    /**
     * Saves a document in the archive.
     * @see org.murygin.archive.service.IArchiveService#save(org.Photo.archive.service.Document)
     */
    public PhotoMetadata save(Photo document) {
        getDocumentDao().insert(document); 
        return document.getMetadata();
    }
    
    /**
     * Finds document in the archive
     * @see org.murygin.archive.service.IArchiveService#findDocuments(java.lang.String, java.util.Date)
     */
    public List<PhotoMetadata> findDocuments(String personName, Date date) {
        return getDocumentDao().findByPersonNameDate(personName, date);
    }
    
    /**
     * Returns the document file from the archive
     * @see org.murygin.archive.service.IArchiveService#getDocumentFile(java.lang.String)
     */
    public byte[] getDocumentFile(String id) {
        Photo document = getDocumentDao().load(id);
        if(document!=null) {
            return document.getFileData();
        } else {
            return null;
        }
    }


    public PhotoFileSystemDao getDocumentDao() {
        return DocumentDao;
    }

    public void setDocumentDao(PhotoFileSystemDao documentDao) {
        DocumentDao = documentDao;
    }


}
