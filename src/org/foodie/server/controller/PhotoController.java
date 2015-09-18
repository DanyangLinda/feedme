package org.foodie.server.controller;

import java.util.Date;
import org.foodie.server.service.Photo;
import org.foodie.server.service.PhotoMetadata;
import org.foodie.server.service.PhotoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author wangfei
 *
 */

@RestController
@RequestMapping("/data")
public class PhotoController {
	PhotoService archiveService = new PhotoService();
	
	/**
     * Adds a document to the archive.
     * 
     * Url: /data/upload?file={file}&person={person}&date={date} [POST]
     * @param file A file posted in a multipart request
     * @param person The name of the uploading person
     * @param date The date of the document
     * @return The meta data of the added document
     */
    @RequestMapping(value = "/img", method = RequestMethod.POST)
    public @ResponseBody PhotoMetadata handleFileUpload(
            @RequestParam(value="file", required=true) MultipartFile file ) {
        
        try {
        	//@DateTimeFormat(pattern="yyyy-MM-dd"
        	Date date = new Date();
        	String person = "Admin";
            Photo document = new Photo(file.getBytes(), file.getOriginalFilename(), date, person );
            getArchiveService().save(document);
            return document.getMetadata();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }      
    }
    
    /**
     * Finds document in the archive. Returns a list of document meta data 
     * which does not include the file data. Use getDocument to get the file.
     * Returns an empty list if no document was found.
     * 
     * Url: /archive/documents?person={person}&date={date} [GET]
     * 
     * @param person The name of the uploading person
     * @param date The date of the document
     * @return A list of document meta data
     */    
    @RequestMapping(value="/img/{id}", method=RequestMethod.GET, produces = "image/png")
    public @ResponseBody byte[]  getImage(@PathVariable("id") String id){
    	HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.IMAGE_JPEG);
        System.out.println("Input id of image: "+id);
        byte[] res = getArchiveService().getDocumentFile(id);
        System.out.println("Return result of image: "+res);
        return res;
    }

    public PhotoService getArchiveService() {
        return archiveService;
    }

    public void setArchiveService(PhotoService archiveService) {
        this.archiveService = archiveService;
    }
 }
