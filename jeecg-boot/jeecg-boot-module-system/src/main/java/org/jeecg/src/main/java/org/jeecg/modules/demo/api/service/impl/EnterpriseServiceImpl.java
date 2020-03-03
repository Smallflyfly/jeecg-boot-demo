package org.jeecg.modules.demo.api.service.impl;

import org.jeecg.modules.demo.api.entity.Enterprise;
import org.jeecg.modules.demo.api.mapper.EnterpriseMapper;
import org.jeecg.modules.demo.api.service.IEnterpriseService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 企业表
 * @Author: jeecg-boot
 * @Date:   2020-03-03
 * @Version: V1.0
 */
@Service
public class EnterpriseServiceImpl extends ServiceImpl<EnterpriseMapper, Enterprise> implements IEnterpriseService {

}
