package com.kluster.orderstock_2.wholestock.mapper;

import com.kluster.orderstock_2.wholestock.domain.Wholestock;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WholestockMapper {
    List<Wholestock> getWholestockItem();
}
