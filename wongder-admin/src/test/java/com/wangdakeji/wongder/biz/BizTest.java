package com.wangdakeji.wongder.biz;

import com.wangdakeji.wongder.base.BaseJunit;
import com.wangdakeji.wongder.modular.biz.service.ITestService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 业务测试
 *
 * @author fengshuonan
 * @date 2017-06-23 23:12
 */
public class BizTest extends BaseJunit {

    @Autowired
    ITestService testService;

    @Test
    public void test() {
        //testService.testWongder();

        testService.testBiz();

        //testService.testAll();
    }
}
