package com.wangdakeji.wongder.common.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 旅行产品表
 * </p>
 *
 * @author cj
 * @since 2018-01-05
 */
public class Product extends Model<Product> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 团号
     */
	private String uuid;
    /**
     * 出发日期
     */
	private Date timestamp;
    /**
     * 航司
     */
	private String aircompany;
    /**
     * 晚数
     */
	@TableField("night_sum")
	private Integer nightSum;
    /**
     * 产品类别
     */
	@TableField("prod_type")
	private String prodType;
    /**
     * 价格
     */
	private Integer price;
    /**
     * 状态
     */
	private Integer state;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getAircompany() {
		return aircompany;
	}

	public void setAircompany(String aircompany) {
		this.aircompany = aircompany;
	}

	public Integer getNightSum() {
		return nightSum;
	}

	public void setNightSum(Integer nightSum) {
		this.nightSum = nightSum;
	}

	public String getProdType() {
		return prodType;
	}

	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Product{" +
			"id=" + id +
			", uuid=" + uuid +
			", timestamp=" + timestamp +
			", aircompany=" + aircompany +
			", nightSum=" + nightSum +
			", prodType=" + prodType +
			", price=" + price +
			", state=" + state +
			"}";
	}
}
