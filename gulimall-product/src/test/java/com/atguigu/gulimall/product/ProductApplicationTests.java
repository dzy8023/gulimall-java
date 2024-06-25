package com.atguigu.gulimall.product;

import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductApplicationTests {
	@Autowired
BrandService brandService;
	@Test
	void contextLoads() {
		BrandEntity brandEntity = new BrandEntity();
		brandEntity.setBrandId(1L);
		brandEntity.setName("华为");
		brandEntity.setDescript("华为手机");

//		brandService.save(brandEntity);
		brandService.updateById(brandEntity);
		System.out.println("保存成功-------");
BrandEntity brand=brandService.getById(1L);
		System.out.println(brand.toString());
	}

}
