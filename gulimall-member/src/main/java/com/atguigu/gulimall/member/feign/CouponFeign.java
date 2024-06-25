package com.atguigu.gulimall.member.feign;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 1.引入open-feign依赖
 * 2.创建一个接口，定义好要调用的微服务的接口
 * 3.使用@FeignClient注解，指定要调用的微服务名称
 * 4.在接口中定义好要调用的微服务的接口，并使用RequestMapping注解指定请求路径
 * 5.开启远程调用功能，在启动类上添加@EnableFeignClients注解
 */
@FeignClient("gulimall-coupon")
public interface CouponFeign {
    @RequestMapping("/coupon/coupon/member/list")
    public R memberCoupons();



}
