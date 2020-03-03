package org.jeecg.fangpf.api.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.fangpf.api.entity.Enterprise;
import org.jeecg.fangpf.api.service.IEnterpriseService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

 /**
 * @Description: 企业表
 * @Author: jeecg-boot
 * @Date:   2020-03-03
 * @Version: V1.0
 */
@Api(tags="企业表")
@RestController
@RequestMapping("/api/enterprise")
@Slf4j
public class EnterpriseController extends JeecgController<Enterprise, IEnterpriseService> {
	@Autowired
	private IEnterpriseService enterpriseService;
	
	/**
	 * 分页列表查询
	 *
	 * @param enterprise
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "企业表-分页列表查询")
	@ApiOperation(value="企业表-分页列表查询", notes="企业表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(Enterprise enterprise,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<Enterprise> queryWrapper = QueryGenerator.initQueryWrapper(enterprise, req.getParameterMap());
		Page<Enterprise> page = new Page<Enterprise>(pageNo, pageSize);
		IPage<Enterprise> pageList = enterpriseService.page(page, queryWrapper);
		return Result.ok(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param enterprise
	 * @return
	 */
	@AutoLog(value = "企业表-添加")
	@ApiOperation(value="企业表-添加", notes="企业表-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody Enterprise enterprise) {
		enterpriseService.save(enterprise);
		return Result.ok("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param enterprise
	 * @return
	 */
	@AutoLog(value = "企业表-编辑")
	@ApiOperation(value="企业表-编辑", notes="企业表-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody Enterprise enterprise) {
		enterpriseService.updateById(enterprise);
		return Result.ok("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "企业表-通过id删除")
	@ApiOperation(value="企业表-通过id删除", notes="企业表-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		enterpriseService.removeById(id);
		return Result.ok("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "企业表-批量删除")
	@ApiOperation(value="企业表-批量删除", notes="企业表-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.enterpriseService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.ok("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "企业表-通过id查询")
	@ApiOperation(value="企业表-通过id查询", notes="企业表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		Enterprise enterprise = enterpriseService.getById(id);
		if(enterprise==null) {
			return Result.error("未找到对应数据");
		}
		return Result.ok(enterprise);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param enterprise
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Enterprise enterprise) {
        return super.exportXls(request, enterprise, Enterprise.class, "企业表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Enterprise.class);
    }

}
