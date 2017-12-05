package com.zsw.framework.util;

/**
 * 
 * @author 460098508@qq.com
 * @date 2016-6-22 上午09:57:41
 * @description
 */
public final class ContentType {
	public static final String TEXT = "text/plain";
	public static final String HTML = "text/html";
	public static final String CSS = "text/css";
	public static final String XML = "text/xml";
	public static final String JSON = "application/json";
	public static final String JAVASCRIPT = "text/javascript";
	
	public static final String STREAM = "application/octet-stream";
	public static final String JPEG = "image/jpeg";
	public static final String PDF = "application/pdf";
	public static final String RTF = "application/rtf";
	public static final String MSWORD = "application/msword";
	public static final String MSEXCEL = "application/vnd.ms-excel";
	public static final String MSPOWERPOINT = "application/vnd.ms-powerpoint";
	
	public static String getFileContentType(String fileName){
		String str = StringUtil.getFileExt(fileName).toLowerCase();
		if(str.endsWith("pdf")){
			return PDF;
		}else if(str.endsWith("doc") || str.endsWith("docx")){
			return MSWORD;
		}else if(str.endsWith("xls") || str.endsWith("xlsx")){
			return MSEXCEL;
		}else if(str.endsWith("ppt") || str.endsWith("pptx")){
			return MSPOWERPOINT;
		}else if(".bmp.jpg.tiff.gif.pcx.tga.exif.fpx.svg.psd.cdr.pcd.dxf.ufo.eps.ai.raw.png.ico".indexOf(str) != -1) {
			return JPEG;
		}		
		
		return STREAM;
	}
	
}
