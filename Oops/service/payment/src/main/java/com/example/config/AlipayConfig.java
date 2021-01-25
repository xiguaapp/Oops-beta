package com.example.config;

public class AlipayConfig {
    // 商户appid
    public static String APPID = "2021000116694204";
    // 私钥 pkcs8格式的
    public static String RSA_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCkBw8OJE+41inyjZh9dLfNqrykc5iUYQ9s7z1intao48/Ui9lOKdPirYZGnDlHGcg/7AiHcEzRXp+Ir6oyPYy22H6KiDztk7tuBF5flzmYFszvZ3kMXDh0i1xB7g8OUdY5sjZ34Ir1ZJugloui8d0E2Ejywx3z1GJAViV2LFP9zLATahLLikZG7Vf0A6kPGr7NEutXRZGa2w+haOeNpauwRs/yion++PjtNpS+HtPkQ124UVtQS5sIrQTqDLN7YGKdesSudngYPO3xnm6ujrG9IILxm3ODMgIUsxeb68uwl4IObHbA3xyjHwa27Fu0EKyjlJHSk7DVIQEyxCmmop0rAgMBAAECggEADIJVTZjLU6dRj6PoyziJg+/PbyM5sactS/t6zPicGkk1Ylo/+kwKUrE1GlFztM5sjSNtCxcvZJA4zm3HJwm2n4MnM11seBnaI2vF3rhjtguXGXLksmKeE5VFNen3z/nBwqiqqr2/GzPPApI4l/amCmaMOadTs3KxA4MOXFLJHQPN6KpD7rigmVtIFpUuFIqni4bX7N4HeJekZ2JA6AJK1Q1Jadm88ErZog3TaZBwfeZRGvTnnkY+hEvH+VI7vZkZqyHYlG7cLIObDTS2pZLQUPRBBnEThnxcF5OxUJhVT2sMZgGrVST1PfetB7k/zCgAyUApaBRvSHb0EUIjVVD3sQKBgQDWJJfyiPuwNiFxOQgmyneYuCiYw9BAv1x72hDj/B68LgASwa73ott2b/5Ojc6gKYGDAGnBEF4SgqapUx8GktoBXh7wTIcpQ9aA+ZUaot8DNUvfBOK8IEcSSm/tYEE23JKTcfzdbv+QFZKcfOR0PDV7g/u/uH+pI8EYDe3RP6DTtwKBgQDEFsOMfVRVBDPODJAd4+U3/+UgStR3V+c4jb0BgZZcb+7sW555+jFI3vnqOlwvTqP+GQSqlHLe9L+OprGXMw8S3kUAAhQn1Oxw";
//    // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    public static String notify_url = "https://www.baidu.com/";
//    // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
//    public static String return_url = "https://www.baidu.com/";

    public static String notify_url = "http://localhost:9006/alipay/alipayNotifyNotice";
    public static String return_url = "http://localhost:9006/alipay/alipayReturnNotice";
    // 请求网关地址
    public static String URL = "https://openapi.alipaydev.com/gateway.do";
    // 编码
    public static String CHARSET = "UTF-8";
    // 返回格式
    public static String FORMAT = "json";
    // 支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "0fDAAPUkc7kVs3OsPiW1TK5FxmOyckWvJWVjfyMj6c0BDPFKC/7/ek+k6bv2pEAGOe36mCnKLQKBgQC72Wn5djTjhPidK9x8ustjCtmB+PPseHGWq9p5RCdqCChES+dCkHhYUzIQktEZKo/T7T7X/5WmQzoT+ziSOaxH2trlDRzcFAhNJ6OmtA1R8STXRJ/pS59M6kN5RiCvEZr7ANlDHiXNrT7pS53UYSTBbyweKKjEJPs0MLPYBSr9zQKBgFJ8xPwniL9OykAmdsWsJbO9+PPxppkhqEnZDiZBDjCKgbZ6ABuNzQe7jOQkcr0P1trASX88fWofCSoII3LYbsHgMKSFO1daMbBwEFekz3rrF3Pyjnlpl1FCFZmSkEPz4C6Ci7kkNXMZGj0T5bjhfP6ZxEE6dfCWPbygx+R/+CxtAoGBAK8Ko6KEb/cZaeK8EcJtYY1KEKSiD/23t4LDn4RYUKHUExjUPwxv9vaoYVvtfsHzwwkaiAJE0xvFsZLRYdG0GkZx9WCnGeWrxF7ZJ6Og68RcaHPbMhN1Hmqe5KGf2qHo2YPA+Obni9d7JVSbWVpVk0kgA4s6dhI1ff2KtFfPFU2p";
    // 日志记录目录
    public static String log_path = "/log";
    // RSA2
    public static String SIGNTYPE = "RSA2";
}
