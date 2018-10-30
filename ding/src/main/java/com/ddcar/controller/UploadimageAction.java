package com.ddcar.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.common.BaseBean;
import com.common.Commonparam;




@Controller
public class UploadimageAction {
	private final static Logger logger = LoggerFactory.getLogger(UploadimageAction.class);

	@Value("${imageStorePath}")
	public String imageStorePath;
	@Value("${imageWebHttp}")
	public String imageWebHttp;
	/**
	 * 图片上传，注意跨域，不能上传
	 */
	@RequestMapping("/uploadimage/uploadModelImage")
	public void uploadModelImage(
			Integer maxSize,
			Integer imgSrc,
			Integer width,
			Integer height,
			@RequestParam("uploadFile") MultipartFile uploadFile,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BaseBean bean = new BaseBean();

		if (uploadFile != null&&!uploadFile.isEmpty()) {
			boolean flag=true;
			if(width!=null && height!=null) {

				BufferedImage sourceImg = ImageIO.read(uploadFile.getInputStream());
				int imgWidth = sourceImg.getWidth();
				int imgHeight = sourceImg.getHeight();

				if(imgHeight>height.intValue()){
					flag=false;
					bean.setStatus(400);
					bean.setMsg("请选择图片尺寸"+height+"×"+width+"以内");
				}
				if(imgWidth>width.intValue()){
					flag=false;
					bean.setStatus(400);
					bean.setMsg("请选择图片尺寸"+height+"×"+width+"以内");
				}
			}
			if(maxSize!=null && flag){
				BufferedInputStream fileIn = new BufferedInputStream(uploadFile.getInputStream());
				if(fileIn.available()/1024>maxSize.intValue()){
					flag=false;
					bean.setStatus(400);
					bean.setMsg("请选择图片"+maxSize+"K以内");
				}

			}
			if(flag){
				if(imgSrc==null){imgSrc=0;}
				BaseBean bean1 = Commonparam.saveFile(imageStorePath,imageWebHttp,uploadFile.getInputStream(),
						uploadFile.getOriginalFilename(), imgSrc);
				bean.setStatus(200);
				bean.setRows(bean1.getRows());
			}
		} else {
			bean.setStatus(400);
			bean.setMsg("请选择图片!");
		}

		String json = JSONObject.toJSONString(bean);
		response.getOutputStream().write(json.getBytes("UTF-8"));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/uploadimage/uploadHtmlFile")
	public void uploadHtmlFile(
			@RequestParam("filedata") MultipartFile filedata,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HashMap rt = new HashMap();
		try {
			String filedataFileName = filedata.getOriginalFilename();
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM");
			String ext = filedataFileName.substring(
					filedataFileName.lastIndexOf("."),
					filedataFileName.length());

			String newfilename = Commonparam.makeNewFileName(filedataFileName);
			String targetFolder = Commonparam.htmlImage
					+ Commonparam.makeYearMonth(new Date());
			String absolute = imageStorePath+ targetFolder;

			File absoluteFolder = new File(absolute);
			if (!absoluteFolder.exists()) {
				absoluteFolder.mkdirs();
			}

			BufferedInputStream fileIn = new BufferedInputStream(
					filedata.getInputStream());

			File file = new File(absolute + "/" + newfilename);
			BufferedOutputStream fileOut = new BufferedOutputStream(
					new FileOutputStream(file));

			byte[] buf = new byte[1024];
			while (true) {
				// 读取数据
				int bytesIn = fileIn.read(buf, 0, 1024);
				if (bytesIn == -1) {
					break;
				} else {
					fileOut.write(buf, 0, bytesIn);
				}
			}

			fileOut.flush();
			fileOut.close();
			long length = file.length();
			ext = ext.toLowerCase();
			if (ext.contains("jpg") || ext.contains("jpeg")
					|| ext.contains("png") || ext.contains("gif")) {
				if (Commonparam.imageMax >= length) {

					rt.put("state", "SUCCESS");
					rt.put("url", imageWebHttp + targetFolder + newfilename);
				} else {
					rt.put("state", "图片大小在800K内!");
					rt.put("url", "图片大小在800K内!");
				}
			} else if (ext.contains("mp3") || ext.contains("mp4")
					|| ext.contains("avi")) {
				if (Commonparam.videoMax >= length) {

					rt.put("state", "SUCCESS");
					rt.put("url", imageWebHttp + targetFolder + newfilename);
				} else {
					rt.put("err", "视频大小在100M内!");
					rt.put("url", "视频大小在100M内!");
				}
			} else if (ext.contains("swf")) {
				if (Commonparam.swfMax >= length) {

					rt.put("state", "SUCCESS");
					rt.put("url", imageWebHttp	+ targetFolder + newfilename);
				} else {
					rt.put("state", "动画大小在100M内!");
					rt.put("url", "动画大小在100M内!");
				}
			} else {
				if (Commonparam.fileMax >= length) {
					rt.put("state", "SUCCESS");
					rt.put("url", imageWebHttp	+ targetFolder + newfilename);
				} else {
					rt.put("state", "文件大小在10M内!");
					rt.put("url", "文件大小在10M内!");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			rt.put("state", e.getLocalizedMessage());
			rt.put("url", e.getLocalizedMessage());
		}
		String json = JSONObject.toJSONString(rt);
		response.getOutputStream().write(json.getBytes("UTF-8"));

	}
	/**
	 * 临时文件
	 * @param maxSize
	 * @param uploadFile
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/uploadimage/uploadFileTemp")
	public void uploadFileTemp(
			@RequestParam(value = "uploadFile", required = false) CommonsMultipartFile uploadFile,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BaseBean bean = new BaseBean();
		if (uploadFile != null&&!uploadFile.isEmpty()) {
			BaseBean bean1 = Commonparam.compressImage2Temp(imageStorePath,imageWebHttp,uploadFile.getInputStream(),
					uploadFile.getOriginalFilename(), 1024);
			if(bean1.getStatus()==200){
				bean.setStatus(200);
				bean.setRows(bean1.getRows());
			}
			else{
				bean=bean1;
			}

		} else {
			bean.setStatus(400);
			bean.setMsg("请选择图片!");
		}
		String json = JSONObject.toJSONString(bean);
		logger.error("uploadFileTemp======"+json);
		response.getOutputStream().write(json.getBytes("UTF-8"));
	}
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	@RequestMapping(value = "/common/findTable.htm")
//	public void findTable(
//			HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//
//		BaseBean bean = new BaseBean();
//		try {
//			List<HashMap> tableList=userManager.findTable();
//			for(HashMap table : tableList){
//				List<HashMap> colum=userManager.findTableColumList(table.get("table_name").toString());
//				table.put("columList", colum);
//			}
//			request.setAttribute("tableList", tableList);
//			request.getRequestDispatcher("/res/table.jsp").forward(request, response);
//
//		} catch (Exception e) {
//			logger.warn(Commonparam.getRequestParam(request));
//			logger.warn(Commonparam.handle(e));
//			bean.setMsg(e.getLocalizedMessage());
//
//		}
//	}
}
