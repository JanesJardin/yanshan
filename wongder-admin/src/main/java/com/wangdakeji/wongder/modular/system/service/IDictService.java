package com.wangdakeji.wongder.modular.system.service;

/**
 * 字典服务
 *
 * @author cj
 * @date 2017-04-27 17:00
 */
public interface IDictService {

    /**
     * 添加字典
     *
     */
    void addDict(String dictName, String dictValues);

    /**
     * 编辑字典
     *
     */
    void editDict(Integer dictId, String dictName, String dicts);

    /**
     * 删除字典
     *
     */
    void delteDict(Integer dictId);

}
