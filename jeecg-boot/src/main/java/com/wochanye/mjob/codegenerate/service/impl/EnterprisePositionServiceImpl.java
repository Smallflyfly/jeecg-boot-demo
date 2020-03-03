package com.fangpf.mjob.codegenerate.service.impl;

import com.fangpf.mjob.codegenerate.entity.EnterprisePosition;
import com.fangpf.mjob.codegenerate.mapper.EnterprisePositionMapper;
import com.fangpf.mjob.codegenerate.service.IEnterprisePositionService;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 职位相关
 * @Author: jeecg-boot
 * @Date:   2020-02-24
 * @Version: V1.0
 */
@Service
@Primary
public class EnterprisePositionServiceImpl extends ServiceImpl<EnterprisePositionMapper, EnterprisePosition> implements IEnterprisePositionService {

}
