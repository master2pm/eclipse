package com.luru.other;

import java.io.File;

public class FileWord {

	public static void del(File file) {
		if(file.isDirectory()) {
			File[] files = file.listFiles();
			for(File fil:files) {
				del(fil);
			}
		}
		System.out.println("文件-----"+file.getName()+"-----删除"+(file.delete()?"成功":"失败"));
	}
	
	public static void read(File file) {
		if(file.isDirectory()) {
			File[] files = file.listFiles();
			for(File fil:files) {
				
			}
		}
	}

}
