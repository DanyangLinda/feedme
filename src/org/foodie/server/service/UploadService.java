package org.foodie.server.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author Danyang Li
 *
 */
@Service
public class UploadService {
	public String uploadImg(MultipartFile apkFile,String path) throws IOException{
		    	//获取保存的路径，
		        //if (apkFile.isEmpty()) {// 未选择文件
		        //	return "Empty!";
		        //} 
		        //else{
		            //String originFileName = apkFile.getOriginalFilename();
		        	String fileName=UUID.randomUUID().toString();
		            try {
		                //这里使用Apache的FileUtils方法来进行保存
		            	//FileUtils.copyInputStreamToFile(apkFile.getInputStream(),new File(realPath, originFileName));	
		            	FileUtils.copyInputStreamToFile(apkFile.getInputStream(),new File(path, fileName));	
		            	System.out.println("*****************"+path);
		            } catch (IOException e) {
		            	 throw new IOException(e.toString());
		            }
		       //}
		        return fileName;
	}		 
}
