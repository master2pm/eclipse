package com.luru.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.luru.other.FileWord;
import com.luru.other.export;
import com.luru.po.Wltsj;

public class LuAction implements Serializable , ServletResponseAware {
	
	private Wltsj wl = new Wltsj();
	private String filename ;
	private String mtype;
	private Map map;
	private InputStream fileInputStream;
	private String result;
	private String filepath; 
	private ServletResponse response;

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		 
		try {
			this.filepath = URLDecoder.decode(filepath, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			this.filepath = "";
		}
	}

	public String getResult() {
		return result;
	}

	public InputStream getFileInputStream() {
		return fileInputStream;
	}

	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}

	public String getMtype() {
		return mtype;
	}

	public void setMtype(String mtype) {
		this.mtype = mtype;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	
	
	public Map<String, Map> getMap() {
		return map;
	}

	public void setMap(Map<String, Map> map) {
		this.map = map;
	}



	
	public Wltsj getWl() {
		return wl;
	}

	public void setWl(Wltsj wl) {
		this.wl = wl;
	}
	

	private Map addMap(String[] str) {
		Map tempMap = new HashMap<Integer,String>(); 
		for(int i = 0 ; i < str.length ; i++) {
			tempMap.put(i, str[i]);
		}
		return tempMap;
	}
	
	/**
	 * 读取文档库
	 * */
	public String export() {
		map = new HashMap<>();
		Map temp = new HashMap<String,Map>();
		Map temp1 = new HashMap<String,Object>();
		String path = LuAction.class.getResource("/").toString().replaceAll("file:/", "").replaceAll("classes", "cache");
		File[] files = new File(path).listFiles();
		if(files!=null)
		for(int i = 0 ; i < files.length ; i++) {
			Map temp3 = new HashMap<String,Object>();
			String dt = files[i].getName();
			Map temp4 = new HashMap<String,Object>();
			File[] words = files[i].listFiles();
			for(int j = 0 ;j < words.length ; j++) {
				Map temp2 = new HashMap<String,Object>();
				temp2.put("filename", words[j].getName());
				Map tempUrl = new HashMap<String,Object>();
				for(File fil:words[j].listFiles()) {
					String[] type = {"回执","检验整改意见","报告","任务单","委托单","原始记录"};
					String[] type1 = {"hz","yj","bg","rwd","wtd","ysjl"};
					for(int k = 0 ; k < type.length; k ++) {
						if(fil.getName().contains(type[k])) {
							String tempPath = fil.getPath();
							tempUrl.put(type1[k],tempPath.substring(tempPath.indexOf("cache")+6));
						}
					}
				}
				temp2.put("url",tempUrl);
				temp4.put(j,temp2);
			}
			temp3.put("datas",temp4);
			temp3.put("date",dt);
			temp1.put(i,temp3);
		}
		
		map.put("date", temp1);
		return "export_success";
	}
		
	/**
	 * 创建文档
	 * */
	public String add() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		String path = LuAction.class.getResource("/").toString().replaceAll("file:/", "").replaceAll("classes", "cache") + date;
		System.out.println("PATH:"+path);
		File file = new File(path + "/" + filename);
		if(file.exists()) {
    		System.out.println("文件夹已存在");
    	}else {
    		new File(path).mkdirs();
    		System.out.println("文件夹不存在正在创建");
    		System.out.println("创建"+(file.mkdir()?"成功":"失败"));
    	}
		System.out.println("文件名是："+filename);
		export daochu = new export(filename, wl);
		System.out.println(mtype);
		if("物料提升机".equals(mtype)) {
			daochu.createWltsj();
		}else
		if("塔机".equals(mtype)) {
			daochu.createTj();
		}else
		if("施工升降机".equals(mtype)) {
			daochu.createSgt();
		}else
		if("防坠器".equals(mtype)) {
			daochu.createfzq();
		}else
		if("钢管、脚手架扣件".equals(mtype)) {
			daochu.creategj();
		}else
		if("安全建材".equals(mtype)) {
			daochu.createaqqc();
		}
		
		result = "success";
		return "add_success";
	}
	
	/**
	 * 下载文件
	 * */
	public String downloadFile()throws Exception {
		response.setContentType("application/octet-stream");
		System.out.println(filepath);
		filepath = URLDecoder.decode(filepath,"UTF-8");
		String path = LuAction.class.getResource("/").toString().replaceAll("file:/", "").replaceAll("classes", "cache") + URLDecoder.decode(filepath,"UTF-8");
		File file = new File(path);   	
		/**
		 * 要转码 针对下载的文件名
		 * */
		filename = new String(filepath.substring(filepath.lastIndexOf("\\")+1).getBytes(),"ISO-8859-1");
		fileInputStream = new FileInputStream(file);
		return "downloadFile_success";
	}

	/**
	 * 删除文件夹
	 * */
	public String del() {
		result = "success";
		String path = LuAction.class.getResource("/").toString().replaceAll("file:/", "").replaceAll("classes", "cache") + filepath;
		new FileWord().del(new File(path));
		System.out.println(filepath);
		return "del_success";
	}
	
	
	

	public String execute() throws Exception{
		return "";
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}


}
