package com.sunyard.tms.mapper;

import com.sunyard.tms.entity.Device;
import com.sunyard.tms.entity.DeviceExample;
import java.util.List;

import com.sunyard.tms.entity.Merchant;
import org.apache.ibatis.annotations.Param;

public interface DeviceMapper {
    int countByExample(DeviceExample example);

    int deleteByExample(DeviceExample example);

    int deleteByPrimaryKey(String deviceId);

    int insert(Device record);

    int insertSelective(Device record);

    List<Device> selectByExample(DeviceExample example);

    Device selectByPrimaryKey(String deviceId);

    int updateByExampleSelective(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByExample(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);

    List<Device> queryForList(Device device);

    List<Device> showNoMerchantDevice();

    List<Device> findByMerchantId(Merchant merchant);

	int emptyGroupIdByGroup(String groupId);
}