package com.example.server;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.example.config.AlipayConfig;
import com.example.po.OpGiftEntity;
import com.example.po.OpVipEntity;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Service
public class WebPay {
    public void send(HttpServletResponse response, Object t) throws UnsupportedEncodingException {
        // 商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no="";
        // 订单名称，必填
        String subject="";
        // 付款金额，必填
        String total_amount="";
        // 商品描述，可空
        String body="";

        if(t instanceof OpGiftEntity){
            OpGiftEntity op= (OpGiftEntity) t;
            out_trade_no   = new String(("OpGiftEntity_"+ UUID.randomUUID().toString().substring(0,6)).getBytes("ISO-8859-1"),"UTF-8");

            subject = new String(("礼物:"+op.getGifname()).getBytes("ISO-8859-1"),"UTF-8");

            total_amount =new String((""+op.getGifprice()).getBytes("ISO-8859-1"),"UTF-8");

            body = new String(op.getGifname().getBytes("ISO-8859-1"),"UTF-8");
        }else if(t instanceof OpVipEntity){
            OpVipEntity op= (OpVipEntity) t;
            out_trade_no   = new String(("OpVipEntity"+ UUID.randomUUID().toString().substring(0,6)).getBytes("ISO-8859-1"),"UTF-8");

            subject = new String(("会员："+op.getVname()).getBytes("ISO-8859-1"),"UTF-8");

            total_amount =new String((""+op.getVprice()).getBytes("ISO-8859-1"),"UTF-8");

            body = new String(op.getVname().getBytes("ISO-8859-1"),"UTF-8");
        }


        // 超时时间 可空
        String timeout_express="2m";
        // 销售产品码 必填
        String product_code="QUICK_WAP_WAY";
        /**********************/
        // SDK 公共请求类，包含公共请求参数，以及封装了签名与验签，开发者无需关注签名与验签
        //调用RSA签名方式
        AlipayClient client = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY,AlipayConfig.SIGNTYPE);
        AlipayTradeWapPayRequest alipay_request=new AlipayTradeWapPayRequest();

        // 封装请求支付信息
        AlipayTradeWapPayModel model=new AlipayTradeWapPayModel();
        model.setOutTradeNo(out_trade_no);
        model.setSubject(subject);
        model.setTotalAmount(total_amount);
        model.setBody(body);
        model.setTimeoutExpress(timeout_express);
        model.setProductCode(product_code);
        alipay_request.setBizModel(model);
        // 设置异步通知地址
        alipay_request.setNotifyUrl(AlipayConfig.notify_url);
        // 设置同步地址
        alipay_request.setReturnUrl(AlipayConfig.return_url);

        // form表单生产
        String form = "";
        try {
            // 调用SDK生成表单
            form = client.pageExecute(alipay_request).getBody();
            response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
            response.getWriter().write(form);//直接将完整的表单html输出到页面
            response.getWriter().flush();
            response.getWriter().close();
        } catch (AlipayApiException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}