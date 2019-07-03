package ru.ida.springmvc.service;

import org.springframework.transaction.annotation.Transactional;

import ru.ida.springmvc.model.OneClickPurchase;

import java.util.List;

public interface OneClickPurchaseService {
    //get
    @Transactional(readOnly = true)
    List<OneClickPurchase> getOneClickPurchaseList();

    //put
    @Transactional
    OneClickPurchase addOneClickPurchase(OneClickPurchase oneclickpurchase);

    @Transactional
    List<OneClickPurchase> createOneClickPurchases(OneClickPurchase[] oneclickpurchases);

    //post
    @Transactional
    OneClickPurchase updateOneClickPurchase(OneClickPurchase oneclickpurchase);

    @Transactional
    List<OneClickPurchase> updateOneClickPurchases(OneClickPurchase[] oneclickpurchases);

    //delete
    @Transactional
    void deleteOneClickPurchases(long[] uids);


}
