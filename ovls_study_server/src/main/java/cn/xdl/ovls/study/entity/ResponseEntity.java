package cn.xdl.ovls.study.entity;


/**
 * 该类封装的是controller处理的结果
 * 
 * */
public class ResponseEntity {
	
	/**
	 * 结果代码
	 * */
	private int status;
	
	/**
	 * 结果说明
	 * */
	private String msg;
	
	/**
	 * 需要返回的数据
	 * */
	private Object data;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	

}
