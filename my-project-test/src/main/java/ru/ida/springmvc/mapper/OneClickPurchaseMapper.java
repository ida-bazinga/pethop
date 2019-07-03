package ru.ida.springmvc.mapper;

import org.apache.ibatis.annotations.Param;

import ru.ida.springmvc.model.OneClickPurchase;

import java.util.List;

public interface OneClickPurchaseMapper {

    List<OneClickPurchase> getOneClickPurchaseList();

    long addOneClickPurchase(OneClickPurchase oneclickpurchase);

    void updateOneClickPurchase(OneClickPurchase oneclickpurchase);

    void deleteOneClickPurchase(@Param("uid") long uid);
}
