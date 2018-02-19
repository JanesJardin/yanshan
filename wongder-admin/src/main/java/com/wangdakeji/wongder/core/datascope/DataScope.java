package com.wangdakeji.wongder.core.datascope;

import lombok.Data;

import java.util.List;

/**
 * 数据范围
 *
 * @author cj
 * @date 2017-07-23 22:19
 */
@Data
public class DataScope {

    /**
     * 限制范围的字段名称
     */
    private String scopeName = "deptid";

    /**
     * 具体的数据范围
     */
    private List<Integer> scopeIds;

    public DataScope() {
    }

    public DataScope(List<Integer> scopeIds) {
        this.scopeIds = scopeIds;
    }

    public DataScope(String scopeName, List<Integer> scopeIds) {
        this.scopeName = scopeName;
        this.scopeIds = scopeIds;
    }

}
