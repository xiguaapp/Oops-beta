//package com.example.controller;
//
//import com.alipay.api.AlipayApiException;
//import com.alipay.api.AlipayClient;
//import com.alipay.api.DefaultAlipayClient;
//import com.alipay.api.internal.util.AlipaySignature;
//import com.alipay.api.request.AlipayTradePagePayRequest;
//import com.alipay.api.request.AlipayTradeRefundRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.*;
//import springbootalipay.alipay.entity.Flow;
//import springbootalipay.alipay.entity.Orders;
//import springbootalipay.alipay.entity.Product;
//import springbootalipay.alipay.service.FlowService;
//import springbootalipay.alipay.service.OrdersService;
//import springbootalipay.alipay.service.ProductService;
//import springbootalipay.alipay.util.AlipayConfig;
//import springbootalipay.alipay.util.KeyUtil;
//import springbootalipay.alipay.util.OrderStatusEnum;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
//
//@Controller
//public class OrderController {
//    @Autowired
//    OrdersService ordersService;
//    @Autowired
//    ProductService productService;
//    @Autowired
//    FlowService flowService;
//
//    //TODO 创建支付订单
//    @GetMapping("/alipay/buy/{id}/{price}")
//    public String gobuycount(@PathVariable("id")Integer id, @PathVariable("price")Integer price, ModelMap modelMap){
//        Orders orders=new Orders();
//        String orderid=KeyUtil.genUniqueKey();
//        orders.setId(orderid);//订单ip
//        orders.setOrderNum(orderid);//订单编号
//        orders.setProductId(String.valueOf(id));//产品id
//        orders.setBuyCounts(1);//购买数量
//        orders.setCreateTime(new Date());//订单创建日期
//        orders.setOrderAmount(String.valueOf(price));//订单金额
//        orders.setOrderStatus(OrderStatusEnum.WAIT_PAY.key);//订单状态
//        ordersService.createOrder(orders);
//        Product product=productService.selectByPrimaryKey(String.valueOf(id));
//        modelMap.put("order",orders);
//        modelMap.put("p",product);
//        return "goPay";
//    }
//    //跳转到所有订单
//    @GetMapping("/alipay/allorder")
//    public String allorder(ModelMap modelMap){
//        modelMap.put("allorder",ordersService.lookallOrder());
//        return "refund";
//    }
//
//    //退款
//    @PostMapping(value = "/alipay/refund", produces = "text/html; charset=UTF-8")
//    @ResponseBody
//    public String refund(String orderid) throws AlipayApiException {
//        /*
//        //退款查询
//        //获得初始化的AlipayClient
//        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
//        //设置请求参数
//        AlipayTradeFastpayRefundQueryRequest alipayRequest = new AlipayTradeFastpayRefundQueryRequest();
//
//        //商户订单号，商户网站订单系统中唯一订单号
//        String out_trade_no = orderid;
//        Flow flow=flowService.selectByPrimaryKey(orderid);
//        //支付宝交易号
//        String trade_no = flow.getFlowNum();
//        //请二选一设置
//        //请求退款接口时，传入的退款请求号，如果在退款请求时未传入，则该值为创建交易时的外部交易号，必填
//        String out_request_no ="123456";
//        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
//                +"\"trade_no\":\""+ trade_no +"\","
//                +"\"out_request_no\":\""+ out_request_no +"\"}");
//        //请求
//        String result = alipayClient.execute(alipayRequest).getBody();
//        */
//        //获得初始化的AlipayClient
//        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
//
//        //设置请求参数
//        AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();
//
//        //商户订单号，商户网站订单系统中唯一订单号
//        String out_trade_no = orderid;
//
//        Flow flow=flowService.selectByPrimaryKey(orderid);
//        //支付宝交易号
//        String trade_no = flow.getFlowNum();
//
//        //请二选一设置
//        //需要退款的金额，该金额不能大于订单金额，必填
//        String refund_amount = flow.getPaidAmount();
//        //退款的原因说明
//        String refund_reason = "退款原因";
//
//        //标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传
//        String out_request_no = flow.getId();
//
//        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
//                + "\"trade_no\":\""+ trade_no +"\","
//                + "\"refund_amount\":\""+ refund_amount +"\","
//                + "\"refund_reason\":\""+ refund_reason +"\","
//                + "\"out_request_no\":\""+ out_request_no +"\"}");
//
//        //请求
//        String result = alipayClient.execute(alipayRequest).getBody();
//
//        return result;
//    }
//
//    //TODO 去支付
//    @PostMapping(value = "/alipay/gopay", produces = "text/html; charset=UTF-8")
//    @ResponseBody
//    public String gopay(String orderid) throws Exception {
//        Orders orders=ordersService.selectByPrimaryKey(orderid);
//
//        Product product = productService.selectByPrimaryKey(orders.getProductId());
//        //获得初始化的AlipayClient
//        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
//
//        //设置请求参数
//        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
//        alipayRequest.setReturnUrl(AlipayConfig.return_url);
//        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
//
//        //商户订单号，商户网站订单系统中唯一订单号，必填
//        String out_trade_no = orderid;
//        //付款金额，必填
//        String total_amount = orders.getOrderAmount();
//        //订单名称，必填
//        String subject = product.getName();
//        //商品描述，可空
//        String body = "用户订购商品个数：" + orders.getBuyCounts();
//
//        // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
//        String timeout_express = "30m";
//
//        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
//                + "\"total_amount\":\""+ total_amount +"\","
//                + "\"subject\":\""+ subject +"\","
//                + "\"body\":\""+ body +"\","
//                + "\"timeout_express\":\""+ timeout_express +"\","
//                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
//
//        //请求
//        String result = alipayClient.pageExecute(alipayRequest).getBody();
//        return result;
//    }
//    @RequestMapping(value = "/alipay/alipayReturnNotice")
//    public String alipayReturnNotice(HttpServletRequest request,ModelMap model) throws Exception {
//
//        System.out.println("支付成功, 进入同步通知接口...");
//        //获取支付宝GET过来反馈信息
//        Map<String,String> params = new HashMap<String,String>();
//        Map<String,String[]> requestParams = request.getParameterMap();
//        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
//            String name = (String) iter.next();
//            String[] values = (String[]) requestParams.get(name);
//            String valueStr = "";
//            for (int i = 0; i < values.length; i++) {
//                valueStr = (i == values.length - 1) ? valueStr + values[i]
//                        : valueStr + values[i] + ",";
//            }
//            //乱码解决，这段代码在出现乱码时使用
//            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
//            params.put(name, valueStr);
//        }
//
//        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
//        //——请在这里编写您的程序（以下代码仅作参考）——
//        if(signVerified) {
//            //商户订单号
//            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
//
//            //支付宝交易号
//            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
//
//            //付款金额
//            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
//
//            //修改叮当状态，改为 支付成功，已付款;
//            Orders orders=new Orders();
//            orders.setId(out_trade_no);
//            orders.setPaidAmount(total_amount);
//            orders.setPaidTime(new Date());
//            orders.setOrderStatus(String.valueOf(OrderStatusEnum.PAID));
//            ordersService.updateorder(orders);
//
//            //同时新增支付流水
//            Orders order2=ordersService.selectByPrimaryKey(out_trade_no);
//            Flow flow = new Flow();
//            String flowid=KeyUtil.genUniqueKey();
//            flow.setId(flowid);
//            flow.setFlowNum(trade_no);
//            flow.setBuyCounts(order2.getBuyCounts());
//            flow.setCreateTime(new Date());
//            flow.setOrderNum(out_trade_no);
//            flow.setPaidAmount(total_amount);
//            flow.setPaidMethod(1);
//            flow.setProductId(order2.getProductId());
//            flowService.insert(flow);
//            Product product = productService.selectByPrimaryKey(order2.getProductId());
//
//            System.out.println("********************** 支付成功(支付宝同步通知) **********************");
//            System.out.println("* 订单号: {}"+ out_trade_no);
//            System.out.println("* 支付宝交易号: {}"+ trade_no);
//            System.out.println("* 实付金额: {}"+total_amount);
//            System.out.println("* 购买产品: {}"+product.getName());
//            System.out.println("***************************************************************");
//
//            model.put("out_trade_no",out_trade_no);//订单编号
//            model.put("trade_no",trade_no);//支付宝交易号
//            model.put("total_amount",total_amount);//实付金额
//            model.put("productName",product.getName());//购买产品
//        }else {
//            System.out.println("支付, 验签失败...");
//        }
//        return "alipaySuccess";
//    }
//    @RequestMapping(value = "/alipay/alipayNotifyNotice")
//    @ResponseBody
//    public String alipayNotifyNotice(HttpServletRequest request) throws Exception {
//
//
//        System.out.println("支付成功, 进入异步通知接口...");
//
//        //获取支付宝POST过来反馈信息
//        Map<String,String> params = new HashMap<String,String>();
//        Map<String,String[]> requestParams = request.getParameterMap();
//        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
//            String name = (String) iter.next();
//            String[] values = (String[]) requestParams.get(name);
//            String valueStr = "";
//            for (int i = 0; i < values.length; i++) {
//                valueStr = (i == values.length - 1) ? valueStr + values[i]
//                        : valueStr + values[i] + ",";
//            }
//            //乱码解决，这段代码在出现乱码时使用
////			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
//            params.put(name, valueStr);
//        }
//
//        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
//
//        //——请在这里编写您的程序（以下代码仅作参考）——
//
//		/* 实际验证过程建议商户务必添加以下校验：
//		1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
//		2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
//		3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
//		4、验证app_id是否为该商户本身。
//		*/
//        if(signVerified) {//验证成功
//            //商户订单号
//            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
//
//            //支付宝交易号
//            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
//
//            //交易状态
//            String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
//
//            //付款金额
//            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
//
//            if(trade_status.equals("TRADE_FINISHED")){
//                //判断该笔订单是否在商户网站中已经做过处理
//                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
//                //如果有做过处理，不执行商户的业务程序
//
//                //注意： 尚自习的订单没有退款功能, 这个条件判断是进不来的, 所以此处不必写代码
//                //退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
//            }else if (trade_status.equals("TRADE_SUCCESS")){
//                //判断该笔订单是否在商户网站中已经做过处理
//                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
//                //如果有做过处理，不执行商户的业务程序
//
//                //注意：
//                //付款完成后，支付宝系统发送该交易状态通知
//
//                // 修改叮当状态，改为 支付成功，已付款; 同时新增支付流水
//                //修改叮当状态，改为 支付成功，已付款;
//                Orders orders=new Orders();
//                orders.setId(out_trade_no);
//                orders.setOrderStatus(String.valueOf(OrderStatusEnum.PAID));
//                orders.setPaidAmount(total_amount);
//                orders.setPaidTime(new Date());
//                ordersService.updateorder(orders);
//
//
//                //同时新增支付流水
//                Orders order2=ordersService.selectByPrimaryKey(out_trade_no);
//                Flow flow = new Flow();
//                String flowid=KeyUtil.genUniqueKey();
//                flow.setId(flowid);
//                flow.setFlowNum(trade_no);
//                flow.setBuyCounts(order2.getBuyCounts());
//                flow.setCreateTime(new Date());
//                flow.setOrderNum(out_trade_no);
//                flow.setPaidAmount(total_amount);
//                flow.setPaidMethod(1);
//                flow.setProductId(order2.getProductId());
//                flowService.insert(flow);
//                Product product = productService.selectByPrimaryKey(order2.getProductId());
//
//                System.out.println("********************** 支付成功(支付宝异步通知) **********************");
//                System.out.println("* 订单号: {}"+ out_trade_no);
//                System.out.println("* 支付宝交易号: {}"+trade_no);
//                System.out.println("* 实付金额: {}"+total_amount);
//                System.out.println("* 购买产品: {}"+product.getName());
//                System.out.println("***************************************************************");
//            }
//            System.out.println("支付成功...");
//
//        }else {//验证失败
//            System.out.println("支付, 验签失败...");
//        }
//
//        return "success";
//    }
//
//
//}
