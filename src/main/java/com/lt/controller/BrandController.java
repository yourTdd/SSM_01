package com.lt.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lt.entity.Brand;
import com.lt.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    public Result save(@RequestBody Brand brand) {
        boolean flag = brandService.save(brand);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = brandService.delete(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    @PutMapping
    public Result update(@RequestBody Brand brand){
        boolean flag = brandService.update(brand);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @GetMapping
    public Result getAll(){
        List<Brand> brands = brandService.getAll();
        Integer code = brands != null ? Code.GET_OK : Code.GET_ERR;
        String msg = brands != null ? "" : "数据查询失败，请重试！";
        return new Result(code,brands,msg);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Brand brand = brandService.getById(id);
        Integer code = brand != null ? Code.GET_OK : Code.GET_ERR;
        String msg = brand != null ? "" : "数据查询失败，请重试！";
        return new Result(code,brand,msg);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage,@PathVariable int pageSize,Brand brand){
        IPage<Brand> brands = brandService.getPage(currentPage,pageSize,brand);
        if (currentPage>brands.getPages()){
            brands = brandService.getPage((int)brands.getPages(),pageSize,brand);
        }
        Integer code = brands != null ? Code.GET_OK : Code.GET_ERR;
        String msg = brands != null ? "" : "数据查询失败，请重试！";
        return new Result(code,brands,msg);
    }

}
