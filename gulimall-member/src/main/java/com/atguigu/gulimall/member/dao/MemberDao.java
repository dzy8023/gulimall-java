package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author liuhanwen
 * @email 2890716703@qq.com
 * @date 2024-06-23 17:47:07
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
