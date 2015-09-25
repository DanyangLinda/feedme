package org.foodie.server.controller;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * Danyang Li
 */
@RestController
@RequestMapping("/img")
public class ImgController {
	@RequestMapping(value="/{folder:logo|photo}/{logoId}",produces = "image/png")
	@ResponseBody
	public byte[] getLogo(@PathVariable("folder")String folder, @PathVariable("logoId") String id){	
		try {
			return FileUtils.readFileToByteArray(new File("data/"+folder+"/"+id));
		} catch (IOException e) {
			return null;
		}
	}
}
