package com.neuedu.mapper;

import com.neuedu.po.City;
import com.neuedu.po.Province;

import java.util.List;

public interface ProvinceMapper {

    public void addProvince(Province p);

    public void addCity(List<City> cities);
}
