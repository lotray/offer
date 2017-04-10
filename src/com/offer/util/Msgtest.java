package com.offer.util;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;



public class Msgtest {
   public static void sendMsg(String phone,String code) {
      try {
         TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", "23663119", "7b0750d2152c1b8f712a8b23176c4350");
         AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
         req.setExtend( "" );
         req.setSmsType( "normal" );
         req.setSmsFreeSignName( "易offer" );
         req.setSmsParamString( "{name:'"+code+"'}" );
         req.setRecNum(phone);
         req.setSmsTemplateCode( "SMS_52215305" );
         AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
         System.out.println(rsp.getBody());
      }
      catch (Exception e) {
         e.printStackTrace();
      }

   }
}
