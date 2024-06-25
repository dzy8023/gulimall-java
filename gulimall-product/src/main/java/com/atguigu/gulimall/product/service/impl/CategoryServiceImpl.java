package com.atguigu.gulimall.product.service.impl;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;


@Service("CategoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {
    //    @Autowired
//    private CategoryDao categoryDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //查出所有分类,baseMapper在ServiceImpl中注入,就是CategoryDao
        baseMapper.selectList(null);
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);
        //组装成父子结构
        //1.找到所有的一级分类
        List<CategoryEntity> level1Menus = categoryEntities.stream()
                .filter(categoryEntity -> categoryEntity.getParentCid() == 0)
                .peek(menu -> menu.setChildren(getChildren(menu, categoryEntities)))
                .sorted(Comparator.comparingInt(menu -> menu.getSort()==null?0:menu.getSort()))
                .collect(Collectors.toList());

        return level1Menus;
    }

    //递归返回子菜单
    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all) {
        return all.stream()
                .filter(categoryEntity -> Objects.equals(categoryEntity.getParentCid(), root.getCatId()))
                .peek(menu -> menu.setChildren(getChildren(menu, all)))
                //按sort排序,null值排在最后
                .sorted(Comparator.comparing(CategoryEntity::getSort, Comparator.nullsLast(Comparator.naturalOrder())))
                .collect(Collectors.toList());
    }
}