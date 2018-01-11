package com.luru.other;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.luru.po.Wltsj;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class export {
	
	private Configuration configuration = null;
	private String name;
	private Wltsj wl;
	private Map<String, String> dataMap;
	public export(String name,Wltsj wl) {
		configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");
		this.name = name;
		this.wl = wl;
		this.dataMap = new HashMap<>(); 
		getData();
	}
		
	/**共用*/
	public void common() {
		create("检验整改意见");
		create("回执");
	}
	
	/**物料提升机*/
	public void createWltsj() {
		create("物料提升机任务单");
		create("物料提升机委托单");
		create("物料提升机原始记录");
		create("物料提升机报告");
		common();
	}
	
	/**塔机*/
	public void createTj() {
		create("塔机任务单");
		create("塔机检验委托单");
		create("塔机原始记录");
		create("塔机报告");
		common();
	}
	
	/**施工梯*/
	public void createSgt() {
		create("施工升降机任务单");
		create("施工升降机委托单");
		create("施工升降机原始记录");
		create("施工升降机报告");
		common();
	}
	
	
	/**防坠器*/
	public void createfzq() {
		create("防坠器任务单");
		create("防坠器检验委托单");
	}
	
	/**钢管、脚手架扣件*/
	public void creategj() {
		create("钢管、脚手架扣件检验任务单");
		create("钢管、脚手架扣件检验委托单");
	}
	
	/**安全建材*/
	public void createaqqc() {
		create("安全建材检验任务单");
		create("安全建材检验委托单");
	}
	
	/**回执调用的方法，加空格*/
	private void addk(String type,int num) {
		String tt = dataMap.get(type);
		if(tt.length()<num) {
    		String temp = "";
    		for(int i=1;i<=num-tt.length();i++) {
    			temp += " ";
    		}
    		dataMap.put(type, tt+temp);
    	}
	}
	
	/**文件创建*/
	public void create(String ftlname) {
		System.out.println("-------->>>>创建文档方法被调用");
		System.out.println("----------->>>正在生成"+ftlname+".doc");
		configuration = new Configuration();  
        configuration.setDefaultEncoding("utf-8");  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dd = sdf.format(new Date());
        if(ftlname.equals("回执")) {
        	addk("sydw", 33);
        	addk("gcmc", 43);
        	addk("sbxh", 12);
        	addk("ccbh", 12);
        	addk("baxh", 10);
        	System.out.println(dataMap);
        }
        
        String name = dataMap.get("bho") + dataMap.get("wtdw") + "（" + dataMap.get("gcmc").trim() + "）" + ftlname + " " + dd.replaceAll("-", ".");
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        try {
//        	configuration.setClassForTemplateLoading(this.getClass(), "/com");
//        	System.out.println(Test.class.getResource("/").toString().replaceAll("file:/", "").replaceAll("classes", "ftl"));
        	configuration.setDirectoryForTemplateLoading(new File(export.class.getResource("/").toString().replaceAll("file:/", "").replaceAll("classes", "ftl")));
        	
	        File outFile = new File(export.class.getResource("/").toString().replaceAll("file:/", "").replaceAll("classes", "cache") + date + "/" + this.name.trim() + "/" + name +".doc"); 
	        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"),10240); 
	        Template t =  configuration.getTemplate(ftlname+".ftl","utf-8");//以utf-8的编码读取ftl文件  
	        t.process(dataMap, out);  
	        out.close(); 	
		} catch (Exception e) {
			e.printStackTrace();
		}
        
	}
	

	
	/**数据填充*/
	private void getData() { 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String[] date = sdf.format(new Date()).split("-");
		dataMap.put("da1",date[0]);
		dataMap.put("da2",date[1]);
		dataMap.put("da3",date[2]);
		dataMap.put("wtdw", wl.getWtdw());
		dataMap.put("name", wl.getName());
		dataMap.put("phone", wl.getPhone());
		dataMap.put("azdw", wl.getAzdw());
		dataMap.put("sydw", wl.getSydw());
		dataMap.put("gcmc", wl.getGcmc());
		dataMap.put("gcdz", wl.getGcdz());
		dataMap.put("sbxh", wl.getSbxh());
		dataMap.put("baxh", wl.getBabh());
		dataMap.put("sccj", wl.getSccj());
		dataMap.put("ccbh", wl.getCcbh());
		String data = wl.getCcri().trim();
		if(data.length() == 8) {
			data = data.substring(0,4)+"年"+data.substring(4,6)+"月"+data.substring(6,8)+"日";
		}
		dataMap.put("ccri", data);
		String num = wl.getBh();
		if(num.length() == 14) {
			num = num.substring(0,2) + " " + num.substring(2,4) + " " + num.substring(4,10) + " " + num.substring(10);
		}
		dataMap.put("bho", num);
    }  
}
