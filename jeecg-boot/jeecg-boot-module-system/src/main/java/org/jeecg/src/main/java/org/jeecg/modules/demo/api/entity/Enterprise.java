package org.jeecg.modules.demo.api.entity;

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
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 企业表
 * @Author: jeecg-boot
 * @Date:   2020-03-03
 * @Version: V1.0
 */
@Data
@TableName("enterprise")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="enterprise对象", description="企业表")
public class Enterprise implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**名称*/
	@Excel(name = "名称", width = 15)
    @ApiModelProperty(value = "名称")
    private java.lang.String name;
	/**简称*/
	@Excel(name = "简称", width = 15)
    @ApiModelProperty(value = "简称")
    private java.lang.String shortName;
	/**logo*/
	@Excel(name = "logo", width = 15)
    @ApiModelProperty(value = "logo")
    private java.lang.String logo;
	/**公司类型*/
	@Excel(name = "公司类型", width = 15, dicCode = "enterprise_type")
	@Dict(dicCode = "enterprise_type")
    @ApiModelProperty(value = "公司类型")
    private java.lang.String type;
	/**所属行业*/
	@Excel(name = "所属行业", width = 15)
    @ApiModelProperty(value = "所属行业")
    private java.lang.String industry;
	/**所属行政区域编码*/
	@Excel(name = "所属行政区域编码", width = 15)
    @ApiModelProperty(value = "所属行政区域编码")
    private java.lang.String regionId;
	/**所属行政区域全名*/
	@Excel(name = "所属行政区域全名", width = 15)
    @ApiModelProperty(value = "所属行政区域全名")
    private java.lang.String regionFullName;
	/**经度*/
	@Excel(name = "经度", width = 15)
    @ApiModelProperty(value = "经度")
    private java.math.BigDecimal longitude;
	/**纬度*/
	@Excel(name = "纬度", width = 15)
    @ApiModelProperty(value = "纬度")
    private java.math.BigDecimal latitude;
	/**状态*/
	@Excel(name = "状态", width = 15, dicCode = "enterprise_status")
	@Dict(dicCode = "enterprise_status")
    @ApiModelProperty(value = "状态")
    private java.lang.Integer enable;
	/**主页简介*/
	@Excel(name = "主页简介", width = 15)
    @ApiModelProperty(value = "主页简介")
    private java.lang.String homePageTitle;
	/**主页正文*/
	@Excel(name = "主页正文", width = 15)
    @ApiModelProperty(value = "主页正文")
    private java.lang.String homePageText;
	/**联系人*/
	@Excel(name = "联系人", width = 15)
    @ApiModelProperty(value = "联系人")
    private java.lang.String contact;
	/**联系电话*/
	@Excel(name = "联系电话", width = 15)
    @ApiModelProperty(value = "联系电话")
    private java.lang.String contactPhone;
	/**公司照片*/
	@Excel(name = "公司照片", width = 15)
    @ApiModelProperty(value = "公司照片")
    private java.lang.String pictures;
	/**创建人*/
	@Excel(name = "创建人", width = 15)
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建时间*/
	@Excel(name = "创建时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "创建时间")
    private java.util.Date createTime;
	/**修改人*/
	@Excel(name = "修改人", width = 15)
    @ApiModelProperty(value = "修改人")
    private java.lang.String updateBy;
	/**修改时间*/
	@Excel(name = "修改时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "修改时间")
    private java.util.Date updateTime;
}
