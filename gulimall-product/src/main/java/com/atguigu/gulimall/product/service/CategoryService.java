package com.atguigu.gulimall.product.service;

import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author ${author}
 * @email ${email}
 * @date 2024-06-23 13:27:31
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();
}

