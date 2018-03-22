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
import com.sunyard.tms.dto.DeviceAppParaDto;
import com.sunyard.tms.entity.DeviceAppPara;
import com.sunyard.tms.entity.DeviceAppParaExample;
import com.sunyard.tms.entity.DeviceAppParaExample.Criteria;
import com.sunyard.tms.entity.DeviceAppParaMchnt;
import com.sunyard.tms.entity.DeviceAppParaMchntExample;
import com.sunyard.tms.entity.DeviceAppParaTpdu;
import com.sunyard.tms.entity.DeviceAppParaTpduExample;
import com.sunyard.tms.mapper.DeviceAppParaMapper;
import com.sunyard.tms.mapper.DeviceAppParaMchntMapper;
import com.sunyard.tms.mapper.DeviceAppParaTpduMapper;
import com.sunyard.tms.service.DeviceAppParaService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.DateFormat;
import com.sunyard.tms.utils.IPage;
import com.sunyard.tms.utils.PrimaryKeyUtil;
import com.sunyard.tms.utils.PropertyUtil;

/**
 * @Description:终端应用参数管理 服务层接口实现类
 * @author:zhangbo
 * @date:2017年12月5日 下午6:35:49
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DeviceAppParaServiceImpl implements DeviceAppParaService {
	@Autowired
	private DeviceAppParaMapper deviceAppParaMapper;
	@Autowired
	private DeviceAppParaTpduMapper deviceAppParaTpduMapper;
	@Autowired
	private DeviceAppParaMchntMapper deviceAppParaMchntMapper;

	/**
     * @Description:条件分页查询终端应用参数信息
     * @param deviceAppPara
     * @param page
     * @return String
     */
	@Override
	public DataGrid<DeviceAppPara> queryParaByPage(DeviceAppPara deviceAppPara) {
		// 设置条件查询条件
		DeviceAppParaExample example = new DeviceAppParaExample();
		Criteria criteria = example.createCriteria();
		if (!Strings.isNullOrEmpty(deviceAppPara.getDeviceSn())) {
			criteria.andDeviceSnLike("%" + deviceAppPara.getDeviceSn() + "%");
		}
		if (!Strings.isNullOrEmpty(deviceAppPara.getParaVer())) {
			criteria.andParaVerEqualTo(deviceAppPara.getParaVer());
		}
		example.setOrderByClause("DEVICE_SN ASC");
		// 设置分页信息
		PageHelper.startPage(deviceAppPara.getPage().getPageNo(), deviceAppPara.getPage().getPageSize());
		// 执行查询
		List<DeviceAppPara> list = deviceAppParaMapper.selectByExample(example);
		// 取分页信息
		PageInfo<DeviceAppPara> pageInfo = new PageInfo<>(list);
		// 设置返回结果
		DataGrid<DeviceAppPara> dataGrid = new DataGrid<>();
		long total = pageInfo.getTotal();
		dataGrid.setTotal(new Long(total).intValue());
		dataGrid.setRows(list);
		return dataGrid;
	}
	
	/**
	 * @Description:根据关联键分页查询终端应用TPDU参数信息
	 * @param paraId
	 * @param page
	 * @return DataGrid<DeviceAppParaTpdu>
	 */
	@Override
	public DataGrid<DeviceAppParaTpdu> queryTpduByPara(String paraId, IPage page) {
		// 添加查询条件
		DeviceAppParaTpduExample example = new DeviceAppParaTpduExample();
		com.sunyard.tms.entity.DeviceAppParaTpduExample.Criteria criteria = example.createCriteria();
		criteria.andParaIdEqualTo(paraId);
		PageHelper.startPage(page.getPageNo(), page.getPageSize());
		List<DeviceAppParaTpdu> list = deviceAppParaTpduMapper.selectByExample(example);
		// 取分页信息
		PageInfo<DeviceAppParaTpdu> pageInfo = new PageInfo<>(list);
		// 设置返回结果
        DataGrid<DeviceAppParaTpdu> dataGrid = new DataGrid<>();
        long total = pageInfo.getTotal();
        dataGrid.setTotal(new Long(total).intValue());
        dataGrid.setRows(list);
        return dataGrid;
	}
	
	@Override
	public DataGrid<DeviceAppParaMchnt> queryMchntByPara(String paraId, IPage page) {
		// 添加查询条件
		DeviceAppParaMchntExample example = new DeviceAppParaMchntExample();
		com.sunyard.tms.entity.DeviceAppParaMchntExample.Criteria criteria = example.createCriteria();
		criteria.andParaIdEqualTo(paraId);
		PageHelper.startPage(page.getPageNo(), page.getPageSize());
		List<DeviceAppParaMchnt> list = deviceAppParaMchntMapper.selectByExample(example);
		// 取分页信息
		PageInfo<DeviceAppParaMchnt> pageInfo = new PageInfo<>(list);
		// 设置返回结果
        DataGrid<DeviceAppParaMchnt> dataGrid = new DataGrid<>();
        long total = pageInfo.getTotal();
        dataGrid.setTotal(new Long(total).intValue());
        dataGrid.setRows(list);
        return dataGrid;
	}

	/**
     * @Description:添加终端应用参数信息
     * @param deviceAppPara
     * @return String
     */
	@Override
	public String addPara(DeviceAppPara deviceAppPara) {
		// 验证终端序列号和版本号是否被占用
		boolean flag = checkPara(deviceAppPara);
		if (!flag) {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("para.DeviceSnAndParaVerIsFull"));
		}
		// 补全参数信息
		deviceAppPara.setParaId(PrimaryKeyUtil.getPrimaryKey("PA"));
		String time = DateFormat.dateTimeFormat(new Date());
		deviceAppPara.setCreatedDatetime(time);
		deviceAppPara.setUpdateDatetime(time);
		// 设置返回结果
		int result = deviceAppParaMapper.insert(deviceAppPara);
		if (result == 1) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("para.insertParaSuc"));
		} else {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("para.insertParaFail"));
		}
	}
	
	public boolean checkPara(DeviceAppPara deviceAppPara) {
		DeviceAppParaExample example = new DeviceAppParaExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeviceSnEqualTo(deviceAppPara.getDeviceSn());
        criteria.andParaVerEqualTo(deviceAppPara.getParaVer());
        List<DeviceAppPara> list = deviceAppParaMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            return true;
        }
        return false;
    }
	
	/**
     * @Description:添加终端应用TPDU参数信息
	 * @param deviceAppParaTpdu
	 * @return String
	 */
	@Override
	public String addTpdu(DeviceAppParaTpdu deviceAppParaTpdu) {
		// 补全参数信息
		deviceAppParaTpdu.setTpduId(PrimaryKeyUtil.getPrimaryKey("TI"));
		// 设置返回结果
		int result = deviceAppParaTpduMapper.insert(deviceAppParaTpdu);
		if (result == 1) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("para.insertParaSuc"));
		} else {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("para.insertParaFail"));
		}
	}
	
	/**
	 * @Description:添加终端应用MCHNT参数信息
	 * @param deviceAppParaMchnt
	 * @return String
	 */
	@Override
	public String addMchnt(DeviceAppParaMchnt deviceAppParaMchnt) {
		// 补全参数信息
		deviceAppParaMchnt.setMchntId(PrimaryKeyUtil.getPrimaryKey("MI"));
		// 设置返回结果
		int result = deviceAppParaMchntMapper.insert(deviceAppParaMchnt);
		if (result == 1) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("para.insertParaSuc"));
		} else {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("para.insertParaFail"));
		}
	}
	
	/**
	 * @Description:修改终端应用MCHNT参数信息
	 * @param deviceAppParaMchnt
	 * @return String
	 */
	@Override
	public String updateMchnt(DeviceAppParaMchnt deviceAppParaMchnt) {
		// 设置返回结果
		int result = deviceAppParaMchntMapper.updateByPrimaryKeySelective(deviceAppParaMchnt);
		if (result == 1) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("para.updateParaSuc"));
		} else {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("para.updateParaFail"));
		}
	}

	/**
     * @Description:修改终端应用参数信息
     * @param deviceAppPara
     * @return String
     */
//	@Override
//	public String updatePara(DeviceAppPara deviceAppPara) {
//		// 验证终端序列号和版本号是否被占用
//		boolean flag = checkPara(deviceAppPara);
//		if (!flag) {
//			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("para.DeviceSnAndParaVerIsFull"));
//		}
//		String time = DateFormat.dateTimeFormat(new Date());
//		deviceAppPara.setUpdateDatetime(time);
//		// 设置返回结果
//		int result = deviceAppParaMapper.updateByPrimaryKeySelective(deviceAppPara);
//		if (result == 1) {
//			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("para.updateParaSuc"));
//		} else {
//			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("para.updateParaFail"));
//		}
//	}

	/**
     * @Description:删除终端应用参数信息(物理删除)
     * @param deviceAppPara
     * @return String
     */
//	@Override
//	public String deletePara(DeviceAppPara deviceAppPara) {
//		// 设置返回结果
//		int result = deviceAppParaMapper.deleteByPrimaryKey(deviceAppPara);
//		if (result == 1) {
//			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("para.deleteParaSuc"));
//		} else {
//			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("para.deleteParaFail"));
//		}
//	}

	/**
	 * @Description:根据终端序列号查询最新参数信息
	 * @param deviceAppPara
	 * @return DeviceAppPara
	 */
	@Override
	public DeviceAppParaDto queryLatestVersionPara(DeviceAppPara deviceAppPara) {
		DeviceAppParaExample example = new DeviceAppParaExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeviceSnEqualTo(deviceAppPara.getDeviceSn());
        example.setOrderByClause("PARA_VER DESC");
        List<DeviceAppPara> list = deviceAppParaMapper.selectByExample(example);
        DeviceAppParaDto paraDto = new DeviceAppParaDto();
        if (list.size() > 0) {
        	DeviceAppPara para = list.get(0);
        	paraDto.setDeviceAppPara(para);
        	if (!Strings.isNullOrEmpty(paraDto.getDeviceAppPara().getParaId())) {
        		DeviceAppParaTpduExample tpduExample = new DeviceAppParaTpduExample();
            	com.sunyard.tms.entity.DeviceAppParaTpduExample.Criteria tpduCriteria = tpduExample.createCriteria();
            	tpduCriteria.andParaIdEqualTo(paraDto.getDeviceAppPara().getParaId());
            	List<DeviceAppParaTpdu> tpdu = deviceAppParaTpduMapper.selectByExample(tpduExample);
            	paraDto.setDeviceAppParaTpdu(tpdu);
        		DeviceAppParaMchntExample mchntExample = new DeviceAppParaMchntExample();
            	com.sunyard.tms.entity.DeviceAppParaMchntExample.Criteria mchntCriteria = mchntExample.createCriteria();
            	mchntCriteria.andParaIdEqualTo(paraDto.getDeviceAppPara().getParaId());
            	List<DeviceAppParaMchnt> mchnt = deviceAppParaMchntMapper.selectByExample(mchntExample);
            	paraDto.setDeviceAppParaMchnt(mchnt);
			}
		}
        return paraDto;
	}
}