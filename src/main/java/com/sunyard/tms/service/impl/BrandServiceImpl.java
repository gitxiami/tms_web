package com.sunyard.tms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.entity.Brand;
import com.sunyard.tms.entity.BrandExample;
import com.sunyard.tms.entity.BrandExample.Criteria;
import com.sunyard.tms.entity.Model;
import com.sunyard.tms.entity.ModelExample;
import com.sunyard.tms.mapper.BrandMapper;
import com.sunyard.tms.mapper.ModelMapper;
import com.sunyard.tms.service.BrandService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.DateFormat;
import com.sunyard.tms.utils.PrimaryKeyUtil;
import com.sunyard.tms.utils.PropertyUtil;

/**
 * @Description:厂商管理 服务层接口实现类
 * @author:zhangbo
 * @date:2017年7月12日 下午2:19:17
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandMapper brandMapper;
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * @Description:条件分页查询厂商信息
	 * @param brand
	 * @return DataGrid<Brand>
	 */
	@Override
	public DataGrid<Brand> queryBrandByPage(Brand brand) {
		// 设置条件查询条件
		BrandExample example = new BrandExample();
		Criteria criteria = example.createCriteria();
		if (!Strings.isNullOrEmpty(brand.getBrandName())) {
			criteria.andBrandNameLike("%" + brand.getBrandName() + "%");
		}
		example.setOrderByClause("BRAND_ID ASC");
		// 设置分页信息
		PageHelper.startPage(brand.getPage().getPageNo(), brand.getPage().getPageSize());
		// 执行查询
		List<Brand> list = brandMapper.selectByExample(example);
		// 取分页信息
		PageInfo<Brand> pageInfo = new PageInfo<>(list);
		// 设置返回结果
		DataGrid<Brand> dataGrid = new DataGrid<>();
		long total = pageInfo.getTotal();
		dataGrid.setTotal(new Long(total).intValue());
		dataGrid.setRows(list);
		return dataGrid;
	}

	/**
	 * @Description:添加厂商信息
	 * @param brand
	 * @return String
	 */
	@Override
	public String addBrand(Brand brand) {
		// 验证厂商名称是否存在
		boolean flag = checkBrandname(brand);
		if (!flag) {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("brand.BrandNameIsFull"));
		}
		// 补全厂商信息
		brand.setBrandId(PrimaryKeyUtil.getPrimaryKey("BR"));
		String time = DateFormat.dateTimeFormat(new Date());
		brand.setCreatedDatetime(time);
		brand.setUpdateDatetime(time);
		// 设置返回结果
		int result = brandMapper.insert(brand);
		if (result == 1) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("brand.insertBrandSuc"));
		} else {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("brand.insertBrandFail"));
		}
	}

	/**
	 * @Description:验证厂商名称是否存在
	 * @param brand
	 * @return boolean
	 */
	public boolean checkBrandname(Brand brand) {
        BrandExample example = new BrandExample();
        Criteria criteria = example.createCriteria();
        criteria.andBrandNameEqualTo(brand.getBrandName());
        List<Brand> list = brandMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            return true;
        }
        return false;
    }

	/**
	 * @Description:修改厂商信息
	 * @param brand
	 * @return String
	 */
	@Override
	public String updateBrand(Brand brand) {
		if (!brand.getBrandName().equals(brandMapper.selectByPrimaryKey(brand.getBrandId()).getBrandName())) {
			// 验证厂商名称是否存在
			boolean flag = checkBrandname(brand);
			if (!flag) {
				return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("brand.BrandNameIsFull"));
			}
		}
		String time = DateFormat.dateTimeFormat(new Date());
		brand.setUpdateDatetime(time);
		// 设置返回结果
		int result = brandMapper.updateByPrimaryKeySelective(brand);
		if (result == 1) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("brand.updateBrandSuc"));
		} else {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("brand.updateBrandFail"));
		}
	}

	/**
	 * @Description:删除厂商信息(物理删除)
	 * @param brand
	 * @return String
	 */
	@Override
	public String deleteBrand(Brand brand) {
		String brandId = brand.getBrandId();
		// 设置绑定型号的条件查询条件
		ModelExample example = new ModelExample();
		com.sunyard.tms.entity.ModelExample.Criteria criteria= example.createCriteria();
		if (!Strings.isNullOrEmpty(brandId)) {
			criteria.andBrandIdLike("%" + brandId + "%");
		}
		// 执行查询
		List<Model> list = modelMapper.selectByExample(example);
		// 判断该厂商是否绑定型号
		if (list.size() > 0) {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("brand.getModelByBrand"));
		}
		// 设置返回结果
		int result = brandMapper.deleteByPrimaryKey(brandId);
		if (result == 1) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("brand.deleteBrandSuc"));
		} else {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("brand.deleteBrandFail"));
		}
	}

	/**
	 * @Description:查询全部厂商信息
	 * @return List<Brand>
	 */
	@Override
	public List<Brand> queryAllBrands() {
		// 设置条件查询条件
		BrandExample example = new BrandExample();
		List<Brand> list = brandMapper.selectByExample(example);
		return list;
	}
}