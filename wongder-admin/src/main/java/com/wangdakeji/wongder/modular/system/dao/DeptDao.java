package com.wangdakeji.wongder.modular.system.dao;

import com.wangdakeji.wongder.core.node.ZTreeNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 部门dao
 *
 * @author cj
 * @date 2017年2月17日20:28:58
 */
public interface DeptDao {

    /**
     * 获取ztree的节点列表
     *
     */
    List<ZTreeNode> tree();

    List<Map<String, Object>> list(@Param("condition") String condition);

    List<Map<String, Object>> getBySimpleName(@Param("simplename") String simplename);
}
