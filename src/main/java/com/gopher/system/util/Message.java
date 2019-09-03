package com.gopher.system.util;

import com.alibaba.fastjson.annotation.JSONField;

import net.sf.json.JSONArray;

public class Message {
	@JSONField(name = "node_name")
	private String nodeName;
	private String status;
	private String jobid;
	private String message;
	private String spider;
	private String prevstate;
	private JSONArray running;
	private JSONArray finished;
	
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getJobid() {
		return jobid;
	}
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSpider() {
		return spider;
	}
	public void setSpider(String spider) {
		this.spider = spider;
	}
	public String getPrevstate() {
		return prevstate;
	}
	public void setPrevstate(String prevstate) {
		this.prevstate = prevstate;
	}
    public JSONArray getRunning() {
      return running;
    }
    public void setRunning(JSONArray running) {
      this.running = running;
    }
    public JSONArray getFinished() {
      return finished;
    }
    public void setFinished(JSONArray finished) {
      this.finished = finished;
    }

}
