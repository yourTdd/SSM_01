package com.lt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lt.entity.Brand;

import java.util.List;

public interface BrandService {

    boolean save(Brand brand);
    boolean delete(Integer id);
    boolean update(Brand brand);
    List<Brand> getAll();
    Brand getById(Integer id);
    IPage<Brand> getPage(int currentPage,int pageSize);
    IPage<Brand> getPage(int currentPage,int pageSize,Brand brand);
}
