package com.fulllearn.model;

import java.util.Map;

public class AWResponse {
	private boolean ok;
	private Map<String, Object> data;
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
}
