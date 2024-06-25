package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author ${author}
 * @email ${email}
 * @date 2024-06-23 13:27:31
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
