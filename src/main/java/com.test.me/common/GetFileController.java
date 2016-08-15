package com.test.me.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by jingbo.lin on 2016/8/15.
 */
@Controller
@RequestMapping("/getFile")
public class GetFileController {

	@RequestMapping(value = "/getImage")
	public void getImage(HttpServletRequest request,HttpServletResponse response) {
		FileInputStream fis = null;
		response.setContentType("image/jpeg");
		response.setContentType("image/jpeg");
		try {
			OutputStream out = response.getOutputStream();
			File file = new File("C:\\Users\\jingbo.lin\\IdeaProjects\\jia.order.api\\src\\main\\webapp\\resources\\image\\tomcat.jpg");
			fis = new FileInputStream(file);
			byte[] b = new byte[fis.available()];
			fis.read(b);
			out.write(b);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch ( IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
//	public void showImage(HttpServletResponse response, HttpServletRequest request) throws Exception {
//		String rootDir=request.getSession().getServletContext().getRealPath("/");
//		ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
//		try {
//			BufferedImage image = ImageIO.read(new FileInputStream(rootDir + "src\\main\\webapp\\respources\\image\\tomcat.jpg"));
//			ImageIO.write(image, "jpeg", jpegOutputStream);
//		} catch (IllegalArgumentException e) {
//			response.sendError(HttpServletResponse.SC_NOT_FOUND);
//		}
//
//		byte[] imgByte = jpegOutputStream.toByteArray();
//
//		response.setHeader("Cache-Control", "no-store");
//		response.setHeader("Pragma", "no-cache");
//		response.setDateHeader("Expires", 0);
//		response.setContentType("image/jpg");
//		ServletOutputStream responseOutputStream = response.getOutputStream();
//		responseOutputStream.write(imgByte);
//		responseOutputStream.flush();
//		responseOutputStream.close();
//	}


}
