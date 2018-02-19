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
 * 行程住宿表
 * </p>
 *
 * @author cj
 * @since 2018-01-05
 */
public class Travel extends Model<Travel> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 日期
     */
	@TableField("travel_date")
	private Date travelDate;
    /**
     * 行程
     */
	@TableField("travel_name")
	private String travelName;
    /**
     * 住宿
     */
	@TableField("hotel_location")
	private String hotelLocation;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public String getTravelName() {
		return travelName;
	}

	public void setTravelName(String travelName) {
		this.travelName = travelName;
	}

	public String getHotelLocation() {
		return hotelLocation;
	}

	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Travel{" +
			"id=" + id +
			", travelDate=" + travelDate +
			", travelName=" + travelName +
			", hotelLocation=" + hotelLocation +
			"}";
	}
}
