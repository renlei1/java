package com.ahut.cones.config;

/**
 * @author samluo
 * @date 2018/1/23
 * @package com.pet.project.bean
 */
public class BaseResponse {

	private Integer ret = Code.SUCCESS;

	private String msg;

	private Object data = "";

	public BaseResponse() {
	}

	public Integer getRet() {
		return ret;
	}

	public void setReg(Integer ret) {
		this.ret = ret;
	}

	public String getMsg() {
		return msg;
	}

	public BaseResponse setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public Object getData() {
		return data;
	}

	public BaseResponse setData(Object data) {
		this.data = data;
		return this;
	}

	public BaseResponse(String msg) {
		this.msg = msg;
	}

	public BaseResponse(Integer ret) {
		this.ret = ret;
	}

	public BaseResponse(Integer ret, String msg) {
		this.ret = ret;
		this.msg = msg;
	}

	public BaseResponse(Integer ret, String msg , Object data) {
		this.ret = ret;
		this.msg = msg;
		this.data = data;
	}

	//��������Ϊ�˼���֮ǰд�Ķ���������һ��������
	public BaseResponse setCode(Integer ret) {
		this.ret = ret;
		return this;
	}

	public BaseResponse setMessage(String msg) {
		this.msg = msg;
		return this;
	}
}
