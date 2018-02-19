package com.wangdakeji.wongder.common.persistence.model;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author cj
 * @since 2018-01-05
 */
public class Note extends Model<Note> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private Integer id;
	private Date time;
    /**
     * 备注
     */
	private String content;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Note{" +
			"id=" + id +
			", time=" + time +
			", content=" + content +
			"}";
	}
}
