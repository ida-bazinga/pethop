package ru.ida.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ru.ida.springmvc.extjs.ExtData;
import ru.ida.springmvc.extjs.ExtResponse;
import ru.ida.springmvc.model.OneClickPurchase;
import ru.ida.springmvc.service.OneClickPurchaseService;

import java.util.List;

@Controller
public class OneClickPurchaseController {

    @Autowired
    OneClickPurchaseService oneClickPurchaseuserService;

    @RequestMapping(value = "/")
    public ModelAndView main() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(value = "/oneclickpurchase/view", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ExtResponse getOneClickPurchases() {
        ExtData responseData = new ExtData();
        List<OneClickPurchase> oneclickpurchases = oneClickPurchaseuserService.getOneClickPurchaseList();
        responseData.add(oneclickpurchases);
        responseData.setSuccess(true);
        responseData.setMessage("records successfully fetched! Total: " + oneclickpurchases.size());
        return responseData;
    }

    //new
    @RequestMapping(value = "/oneclickpurchase/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ExtResponse create(@RequestBody OneClickPurchase[] oneclickpurchases) {
        ExtData responseData = new ExtData();
        List<OneClickPurchase> addedOneClickPurchases = oneClickPurchaseuserService.createOneClickPurchases(oneclickpurchases);
        responseData.add(addedOneClickPurchases);
        responseData.setSuccess(true);
        responseData.setMessage("records successfully added! Total: " + addedOneClickPurchases.size());
        return responseData;
    }

    //update
    @RequestMapping(value = "/oneclickpurchase/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ExtResponse update(@RequestBody OneClickPurchase[] oneclickpurchases) {
        ExtData responseData = new ExtData();
        List<OneClickPurchase> addedOneClickPurchases = oneClickPurchaseuserService.updateOneClickPurchases(oneclickpurchases);
        responseData.add(addedOneClickPurchases);
        responseData.setSuccess(true);
        responseData.setMessage("records successfully updated! Total: " + addedOneClickPurchases.size());
        return responseData;
    }

    //delete 
    @RequestMapping(value = "/oneclickpurchase/destroy", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ExtResponse delete(@RequestBody long[] uids) {
        oneClickPurchaseuserService.deleteOneClickPurchases(uids);
        ExtData responseData = new ExtData();
        responseData.add(uids.length);
        responseData.setSuccess(true);
        responseData.setMessage("items successfully removed!");
        return responseData;
    }


}
