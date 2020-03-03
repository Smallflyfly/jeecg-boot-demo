package com.fangpf.mjob.codegenerate.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.experimental.Accessors;

/**
 * @Description: 职位相关
 * @Author: jeecg-boot
 * @Date:   2020-02-24
 * @Version: V1.0
 */
@Data
@TableName("enterprise_position")
@Accessors(chain = true)
@ApiModel(value="enterprise_position对象", description="职位相关")
public class EnterprisePosition implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(value = "职位序号")
	/**职位序号*/
	@TableId(type = IdType.ID_WORKER_STR)
    private java.lang.String id;
    @ApiModelProperty(value = "公司Id")
	/**公司Id*/
	@Excel(name = "公司Id", width = 15)
    private java.lang.String enterpriseId;
    @ApiModelProperty(value = "公司名称")
	/**公司名称*/
	@Excel(name = "公司名称", width = 15)
    private java.lang.String enterpriseName;
    @ApiModelProperty(value = "职位名称")
	/**职位名称*/
	@Excel(name = "职位名称", width = 15)
    private java.lang.String position;
    @ApiModelProperty(value = "经验要求")
	/**经验要求*/
	@Excel(name = "经验要求", width = 15)
    private java.lang.String experience;
    @ApiModelProperty(value = "学历要求")
	/**学历要求*/
	@Excel(name = "学历要求", width = 15)
    private java.lang.String education;
    @ApiModelProperty(value = "薪资范围下限")
	/**薪资范围下限*/
	@Excel(name = "薪资范围下限", width = 15)
    private java.lang.Integer salaryLower;
    @ApiModelProperty(value = "薪资范围上限")
	/**薪资范围上限*/
	@Excel(name = "薪资范围上限", width = 15)
    private java.lang.Integer salaryUpper;
    @ApiModelProperty(value = "职位关键词")
	/**职位关键词*/
	@Excel(name = "职位关键词", width = 15)
    private java.lang.String positionKey;
    @ApiModelProperty(value = "岗位描述小标题")
	/**岗位描述小标题*/
	@Excel(name = "岗位描述小标题", width = 15)
    private java.lang.String positionTitle;
    @ApiModelProperty(value = "岗位描述正文内容")
	/**岗位描述正文内容*/
	@Excel(name = "岗位描述正文内容", width = 15)
    private java.lang.String positionContent;
    @ApiModelProperty(value = "工作城市行政区域编码")
	/**工作城市行政区域编码*/
	@Excel(name = "工作城市行政区域编码", width = 15)
    private java.lang.String regionId;
    @ApiModelProperty(value = "工作城市行政区域全名")
	/**工作城市行政区域全名*/
	@Excel(name = "工作城市行政区域全名", width = 15)
    private java.lang.String regionFullName;
    @ApiModelProperty(value = "招聘人数")
	/**招聘人数*/
	@Excel(name = "招聘人数", width = 15)
    private java.lang.Integer hireNumber;
    @ApiModelProperty(value = "工作地址")
	/**工作地址*/
	@Excel(name = "工作地址", width = 15)
    private java.lang.String workAddress;
    @ApiModelProperty(value = "联系方式")
	/**联系方式*/
	@Excel(name = "联系方式", width = 15)
    private java.lang.String phone;
    @ApiModelProperty(value = "发布时间")
	/**发布时间*/
	@Excel(name = "发布时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private java.util.Date releaseTime;
    @ApiModelProperty(value = "状态")
	/**状态*/
	@Excel(name = "状态", width = 15)
    private java.lang.String status;
    @ApiModelProperty(value = "创建者")
	/**创建者*/
	@Excel(name = "创建者", width = 15)
    private java.lang.String createBy;
    @ApiModelProperty(value = "更新者")
	/**更新者*/
	@Excel(name = "更新者", width = 15)
    private java.lang.String updateBy;
    @ApiModelProperty(value = "更新时间")
	/**更新时间*/
	@Excel(name = "更新时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private java.util.Date updateTime;
    @ApiModelProperty(value = "创建时间")
	/**创建时间*/
	@Excel(name = "创建时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private java.util.Date createTime;
}
