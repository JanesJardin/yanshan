package com.wangdakeji.wongder.modular.biz.service.impl;

import com.wangdakeji.wongder.common.constant.DSEnum;
import com.wangdakeji.wongder.common.persistence.dao.TestMapper;
import com.wangdakeji.wongder.common.persistence.model.Test;
import com.wangdakeji.wongder.core.mutidatasource.annotion.DataSource;
import com.wangdakeji.wongder.modular.biz.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试服务
 *
 * @author cj
 * @date 2017-06-23 23:02
 */
@Service
public class TestServiceImpl implements ITestService {


    @Autowired
    TestMapper testMapper;

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public void testBiz() {
        Test test = testMapper.selectById(1);
        test.setId(22);
        test.insert();
    }


    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_WONGDER)
    public void testWongder() {
        Test test = testMapper.selectById(1);
        test.setId(33);
        test.insert();
    }

    @Override
    @Transactional
    public void testAll() {
        testBiz();
        testWongder();
        //int i = 1 / 0;
    }

}
