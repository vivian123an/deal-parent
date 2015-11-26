package me.quxiu.share.result;



import java.util.ArrayList;
import java.util.List;

import me.quxiu.share.query.BaseQuery;


public class ResultSupport<T> implements ResultDO<T> {

	private static final long serialVersionUID = 4661096805690919752L;
	
	private boolean success = true;
	private String resultCode;
	private String message;
	private T model;
	private BaseQuery query;

	private List<T> models = new ArrayList<T>();
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public T getModel() {
		return model;
	}

    /**
	 * 创建一个result。
	 */
    public ResultSupport() {
    }

    /**
     * 创建一个result。
     *
     * @param success 是否成功
     */
    public ResultSupport(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }


    public void setSuccess(boolean success) {
        this.success = success;
    }


    /**
	 * @return the resultCode
	 */
	public String getResultCode() {
		return resultCode;
	}

	/**
	 * @param resultCode the resultCode to set
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public List<T> getModels() {
		return models;
	}

	public void setModels(List<T> models) {
		this.models = models;
	}

	@Override
	public void setModel(T model) {
		this.model= model;
	}
	
	public BaseQuery getQuery() {
		return query;
	}
	
	public void setQuery(BaseQuery query) {
		this.query = query;
	}

	
}
