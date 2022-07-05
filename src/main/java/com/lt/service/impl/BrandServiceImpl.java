package com.lt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lt.dao.BrandDao;
import com.lt.entity.Brand;
import com.lt.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao brandDao;

    @Override
    public boolean save(Brand brand) {
        return brandDao.insert(brand) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return brandDao.deleteById(id) > 0;
    }

    @Override
    public boolean update(Brand brand) {
        return brandDao.updateById(brand) > 0;
    }

    @Override
    public List<Brand> getAll() {
        return brandDao.selectList(null);
    }

    @Override
    public Brand getById(Integer id) {
        return brandDao.selectById(id);
    }

    @Override
    public IPage<Brand> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        return brandDao.selectPage(page,null);
    }

    @Override
    public IPage<Brand> getPage(int currentPage, int pageSize, Brand brand) {
        LambdaQueryWrapper<Brand> lqw = new LambdaQueryWrapper<Brand>();
        lqw.like(brand.getStatus()!=null,Brand::getStatus,brand.getStatus());
        lqw.like(brand.getCompanyName()!=null,Brand::getCompanyName,brand.getCompanyName());
        lqw.like(brand.getBrandName()!=null,Brand::getBrandName,brand.getBrandName());
        IPage page = new Page(currentPage, pageSize);
        return brandDao.selectPage(page,lqw);
    }
}
