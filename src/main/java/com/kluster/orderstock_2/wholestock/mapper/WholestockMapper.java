package com.kluster.orderstock_2.wholestock.mapper;

import com.kluster.orderstock_2.wholestock.domain.Wholestock;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WholestockMapper {
    List<Wholestock> getWholestockItem(Wholestock wholestock);
    List<Wholestock> getItemType(Wholestock wholestock);
    List<Wholestock> getOriginCountry(Wholestock wholestock);
    List<Wholestock> getStorage(String userId);
    int setWholestockItem(Wholestock wholestock);
    int updateItemStorage(Wholestock wholestock);
    int deleteWholestockItem(String itemCode);
    int setWholestockStorageLog(Wholestock wholestock);
    List<Wholestock> getWholestockStorageLog(Wholestock wholestock);
}
