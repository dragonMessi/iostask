package com.zyjg.adtech.bigscreen.entity;

import java.util.Date;

public class Log {
    private String id;

    private String message;

    private Date jlsj;

    private String erroinfo;

    private String zt;//0为业务错误，1为正常，2为应用错误
    
    private String sj;

    private String methyw;

    private String methzw;
    
    private String erroinfodetail;
    
    private String data;
    
    private String jsonXMl;
    
    private String token;
    
    private String yhid;

    public String getErroinfodetail() {
		return erroinfodetail;
	}

	public void setErroinfodetail(String erroinfodetail) {
		this.erroinfodetail = erroinfodetail;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Date getJlsj() {
        return jlsj;
    }

    public void setJlsj(Date jlsj) {
        this.jlsj = jlsj;
    }

    public String getErroinfo() {
        return erroinfo;
    }

    public void setErroinfo(String erroinfo) {
        this.erroinfo = erroinfo == null ? null : erroinfo.trim();
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt == null ? null : zt.trim();
    }

    public String getMethyw() {
        return methyw;
    }

    public void setMethyw(String methyw) {
        this.methyw = methyw == null ? null : methyw.trim();
    }

    public String getMethzw() {
        return methzw;
    }

    public void setMethzw(String methzw) {
        this.methzw = methzw == null ? null : methzw.trim();
    }

	public void setJsonXMl(String jsonXMl) {
		this.jsonXMl = jsonXMl;
	}

	public String getJsonXMl() {
		return jsonXMl;
	}

	public void setSj(String sj) {
		this.sj = sj;
	}

	public String getSj() {
		return sj;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public String getYhid() {
		return yhid;
	}

	public void setYhid(String yhid) {
		this.yhid = yhid;
	}
}