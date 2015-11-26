package me.quxiu.share.result;

import java.io.Serializable;
import java.util.List;

import me.quxiu.share.query.BaseQuery;

/**
 * 
 */
public interface ResultDO<T> extends Serializable {

    /**
     * 设置请求成功标志。
     *
     * @param success 成功标志
     */
    void setSuccess(boolean success);

	/**
	 * 请求是否成功。
	 *
	 * @return 如果成功，则返回<code>true</code>
	 */
	boolean isSuccess();

	/**
	 * 获取返回码
	 * 
	 * @return 返回码
	 */
	String getResultCode();


	/**
	 * 设置返回码
	 * 
	 * @param code
	 */
	void setResultCode(String code);


	/**
	 * 取得model对象
	 * 
	 * @return model对象
	 */
	T getModel();

	/**
	 * 设置model对象。
	 * 
	 * @param model model对象
	 */
	void setModel(T model);

	/**
	 * 设置model对象。
	 * 
	 * @param models model对象
	 */
	void setModels(List<T> models);
	
	/**
	 * 取得所有model对象。
	 * 
	 * @return model对象表
	 */
	List<T> getModels();
	
	/**
	 * 返回信息
	 * @return
	 */
	public String getMessage();

	/**
	 * 返回错误信息
	 * @param message
	 */
	public void setMessage(String message);
	
	/**
	 * 返回查询对象
	 * @param 
	 * @return BaseQuery
	 * @throws
	 */
	public BaseQuery getQuery();
	
	public void setQuery(BaseQuery query);

}

