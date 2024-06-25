package com.atguigu.gulimall.product.service;

import com.atguigu.gulimall.product.entity.CommentReplayEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import java.util.Map;

/**
 * 商品评价回复关系
 *
 * @author ${author}
 * @email ${email}
 * @date 2024-06-23 13:27:31
 */
public interface CommentReplayService extends IService<CommentReplayEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

