package com.kluster.orderstock_2.wholestock.service;

import com.kluster.orderstock_2.wholestock.domain.Wholestock;
import com.kluster.orderstock_2.wholestock.mapper.WholestockMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}

