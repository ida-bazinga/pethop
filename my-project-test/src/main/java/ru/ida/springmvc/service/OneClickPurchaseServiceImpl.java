package ru.ida.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.ida.springmvc.mapper.OneClickPurchaseMapper;
import ru.ida.springmvc.model.OneClickPurchase;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OneClickPurchaseServiceImpl implements OneClickPurchaseService {
    @Autowired
    OneClickPurchaseMapper oneClickPurchaseMapper;

    //get
    @Transactional(readOnly = true)
    public List<OneClickPurchase> getOneClickPurchaseList() {
        return oneClickPurchaseMapper.getOneClickPurchaseList();
    }

    //put
    public OneClickPurchase addOneClickPurchase(OneClickPurchase oneclickpurchase) {
    	oneClickPurchaseMapper.addOneClickPurchase(oneclickpurchase);
        return oneclickpurchase;
    }

    //post
    @Transactional
    public OneClickPurchase updateOneClickPurchase(OneClickPurchase oneclickpurchase) {
    	oneClickPurchaseMapper.updateOneClickPurchase(oneclickpurchase);
        return oneclickpurchase;
    }

    //delete
    @Transactional
    public void deleteOneClickPurchases(long[] uids) {

        for (long uid : uids) {
        	oneClickPurchaseMapper.deleteOneClickPurchase(uid);
        }
    }

    @Transactional
    public List<OneClickPurchase> createOneClickPurchases(OneClickPurchase[] oneclickpurchases) {
        List<OneClickPurchase> data = new ArrayList<OneClickPurchase>();
        for (OneClickPurchase oneclickpurchase : oneclickpurchases) {
            OneClickPurchase storedOneClickPurchase = addOneClickPurchase(oneclickpurchase);
            data.add(storedOneClickPurchase);
        }
        return data;
    }

    @Transactional
    public List<OneClickPurchase> updateOneClickPurchases(OneClickPurchase[] oneclickpurchases) {
        List<OneClickPurchase> data = new ArrayList<OneClickPurchase>();
        for (OneClickPurchase oneclickpurchase : oneclickpurchases) {
            OneClickPurchase storedOneClickPurchase = updateOneClickPurchase(oneclickpurchase);
            data.add(storedOneClickPurchase);
        }
        return data;
    }

}
