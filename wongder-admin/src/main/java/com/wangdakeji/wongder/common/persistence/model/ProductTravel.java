package com.wangdakeji.wongder.common.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 产品行程关系表
 * </p>
 *
 * @author cj
 * @since 2018-01-05
 */
@TableName("product_travel")
public class ProductTravel extends Model<ProductTravel> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	private Integer id;
    /**
     * 产品id
     */
	@TableField("product_id")
	private Integer productId;
    /**
     * 行程id
     */
	@TableField("travel_id")
	private Integer travelId;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getTravelId() {
		return travelId;
	}

	public void setTravelId(Integer travelId) {
		this.travelId = travelId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ProductTravel{" +
			"id=" + id +
			", productId=" + productId +
			", travelId=" + travelId +
			"}";
	}
}
