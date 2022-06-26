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

    public List<Wholestock> getWholestockItem(){
        List<Wholestock> wholestockList = wholestockMapper.getWholestockItem();
        return wholestockList;
    }

    public List<Wholestock> getItemType(Wholestock wholestock){
        List<Wholestock> itemList = wholestockMapper.getItemType(wholestock);
        return itemList;
    }

    public List<Wholestock> getOriginCountry(Wholestock wholestock){
        List<Wholestock> originCountry = wholestockMapper.getOriginCountry();
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

}

