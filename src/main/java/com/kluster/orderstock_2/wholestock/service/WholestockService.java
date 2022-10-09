package com.kluster.orderstock_2.wholestock.service;

import com.kluster.orderstock_2.wholestock.domain.Wholestock;
import com.kluster.orderstock_2.wholestock.mapper.WholestockMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.time.LocalTime.now;

@Service
@Transactional
public class WholestockService {

    private final WholestockMapper wholestockMapper;

    public WholestockService(WholestockMapper wholestockMapper) {
        this.wholestockMapper = wholestockMapper;
    }

    public List<Wholestock> getStorage(String userId){
        List<Wholestock> storageList = wholestockMapper.getStorage(userId);
        return storageList;
    }

    public List<Wholestock> getWholestockItem(Wholestock wholestock){
        List<Wholestock> wholestockList = wholestockMapper.getWholestockItem(wholestock);
        return wholestockList;
    }

    public List<Wholestock> getItemType(Wholestock wholestock){
        List<Wholestock> itemList = wholestockMapper.getItemType(wholestock);
        return itemList;
    }

    public List<Wholestock> getOriginCountry(Wholestock wholestock){
        List<Wholestock> originCountry = wholestockMapper.getOriginCountry(wholestock);
        return originCountry;
    }

    public String getTodayDate(){
        LocalDate now = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return now.format(dateFormatter);
    }

    public int setWholestockItem(Wholestock wholestock) {
        return wholestockMapper.setWholestockItem(wholestock);
    }

    public int updateItemStorage(Wholestock wholestock){
        return wholestockMapper.updateItemStorage(wholestock);
    }

    public int deleteWholestockItem(String itemCode){
        return wholestockMapper.deleteWholestockItem(itemCode);
    }

    public int setWholestockStorageLog(Wholestock wholestock){
        return wholestockMapper.setWholestockStorageLog(wholestock);
    }

    public List<Wholestock> getWholestockStorageLog(Wholestock wholestock){
        List<Wholestock> wholestockStorageLog = wholestockMapper.getWholestockStorageLog(wholestock);
        return wholestockStorageLog;
    }

}

