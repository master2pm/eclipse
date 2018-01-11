package com.luru.po;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**物料提升机*/
public class Wltsj implements Serializable{
	
	/**1.编号*/
	private String bh;
	/**2.委托单位*/
	private String wtdw;
	/**3.联系人*/
	private String name;
	/**4.电话*/
	private String phone;
	/**5.安装单位*/
	private String azdw;
	/**6.使用单位*/
	private String sydw;
	/**7.工程名称*/
	private String gcmc;
	/**8.工程地址*/
	private String gcdz;
	/**9.设备型号*/
	private String sbxh;
	/**10.备案编号*/
	private String babh;
	/**11.生产厂家*/	
	private String sccj;
	/**12.出厂编号*/	
	private String ccbh;
	/**13.出厂日期*/
	private String ccri;
	
	public String getBh() {
		return bh;
	}
	public void setBh(String bh) {
		try {
			this.bh = URLDecoder.decode(bh,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			this.bh = bh;
		}
		
	}
	public String getWtdw() {
		return wtdw;
	}
	public void setWtdw(String wtdw) {
		try {
			this.wtdw = URLDecoder.decode(wtdw,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			this.wtdw = wtdw;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		try {
			this.name = URLDecoder.decode(name,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			this.name = name;
		}
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		try {
			this.phone = URLDecoder.decode(phone,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			this.phone = phone;
		}
	}
	public String getAzdw() {
		return azdw;
	}
	public void setAzdw(String azdw) {
		try {
			this.azdw = URLDecoder.decode(azdw,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			this.azdw = azdw;
		}
	}
	public String getSydw() {
		return sydw;
	}
	public void setSydw(String sydw) {
		try {
			this.sydw = URLDecoder.decode(sydw,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			this.sydw = sydw;
		}
	}
	public String getGcmc() {
		return gcmc;
	}
	public void setGcmc(String gcmc) {
		try {
			this.gcmc = URLDecoder.decode(gcmc,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			this.gcmc = gcmc;
		}
	}

	public String getGcdz() {
		return gcdz;
	}
	public void setGcdz(String gcdz) {
		try {
			this.gcdz = URLDecoder.decode(gcdz,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			this.gcdz = gcdz;
		}
	}
	public String getSbxh() {
		return sbxh;
	}
	public void setSbxh(String sbxh) {
		try {
			this.sbxh = URLDecoder.decode(sbxh,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			this.sbxh = sbxh;
		}
	}
	public String getBabh() {
		return babh;
	}
	public void setBabh(String babh) {
		try {
			this.babh = URLDecoder.decode(babh,"UTF-8").trim();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			this.babh = babh;
		}
	}
	public String getSccj() {
		return sccj;
	}
	public void setSccj(String sccj) {
		try {
			this.sccj = URLDecoder.decode(sccj,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			this.sccj = sccj;
		}
	}
	public String getCcbh() {
		return ccbh;
	}
	public void setCcbh(String ccbh) {
		try {
			this.ccbh = URLDecoder.decode(ccbh,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			this.ccbh = ccbh;
		}
	}
	public String getCcri() {
		return ccri;
	}
	public void setCcri(String ccri) {
		try {
			this.ccri = URLDecoder.decode(ccri,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			this.ccri = ccri;
		}
	}
	
	public Wltsj() {
		
	}
	
	public Wltsj(String bh,String wtdw) {
		this.bh = bh;
		this.wtdw = wtdw;
	}
	
	@Override
	public String toString() {
		return "编号:"+ bh +"\n委托单位:" + wtdw + "\n联系人:" + name + "\n电话:" + phone + "\n安装单位:" + azdw + "\n使用单位:" 
				+ sydw + "\n工程名称:" + gcmc + "\n设备型号:" + sbxh + "\n备案编号:" + babh + "\n生产厂家:" + sccj + "\n出厂编号:" + ccbh + "\n出厂日期:" + ccri;
	}
}
