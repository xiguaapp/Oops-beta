package springbootalipay.alipay.util;
public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000116678431";
    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC/D0LGSK0g0TWweBm2qUHyjDmv/gzZzDW8KJ+0wPrrAOXtHSTvrSTsXUm2YUOpVFObARzthVN8uRLy9Og6fYbA1R5Y1AwTt0Sbd6kwYAk6nDeyHT7HhCsF3G3EN8mfJRal0MBJbxgvYrbPxbtAhPkH19qRJLODsognoNV0mkkIZXvyVqJRHyeiVuWHRw3UV4nQj61h1rtGn3Q48mgmYhbMmnzWuN6GEVQlyAu0BvpTghxdeRU0NiufaS64jTFT4n6QRtKYNGx7otnx3cMFgJVPeSBaNA4UKB7MtLYlIRq3EnTUcbcKwrtjn2fF2B8StRSDJxFQw+S5fEg4WfNxDfmRAgMBAAECggEAWz7rkgz1ef3QWVYSWbUeBLtJda6r7nxjkVgJZebgLsnABWzszfZv8t5erNZo3P6j6xwt95W8GI2+6f9ixURbzc46bwveNLBK+MC+MZc78RzYUJ089UY+0c7DMXm/Nd0dotU+cBO5hi/rxPDXC+o1kLRa8wSHIzdpZRuftc9VX8da8G5XHht08hKsA6ofI7DmgFgw1WOd2gHVUqulmzyga7Q8PpSR0Pa9myUe0HwTxWUE1FaUnpzvbdMXeWziDs3165y56rIa6w6JAAobQCPQe0zFo4Ii/MUGwCoG6MFD26/0zvVCMTOrneqUlrNqal6FxGG+yHPc+n+0N93OYdrirQKBgQD6vNBnak1rJaZHPqNm3h28yBHkmHbHeypX4FNuR3wFVipoDqqfXH15GPrUcLsYBtNvVb4qVlWl1PZ4Pssy9sGjDMsW+Kvvt6SuCMi0APcMaLIkzq5M1HjuxVPtCRzHT7k0dj2my7P6OR0cEKXYLQtGVfdWaBP4jkSHrhymB+oaBwKBgQDDEc24QpwF8J3SY/kTvPq6zta/bMZSJx2qGoAbB6+0O9QjL76cbNjCs5f2KwWCHeQXnkfm+MpIeTdpTQXgdpkgVjCgnLHedNKqgMfSAdqcHyE1I/Wohh12kpj+BbX7C2It1a0QoIFlNgHcuObKVpXjUgmhUqa72foEnFCzi/1JpwKBgGr/rjOjgnwp6eZXTaW1PZ11B2W0xmNkJPKxMQlLihpA5gHX2Gn/LzBBP7DulnivWQUW4vrwMsZ8td0kdtQ9xu5MpFIeNkkq5iS6bOOb0dFC0FqytGDm/uBt5t2tWNGZLOC9YJvQK/Ko8soqNIum1TvjrZP7ACK+m3IHFASqNfV7AoGBAI1mkGrqzdJ4cs6ZbWnjaRSU7pHgNXpDpHszrnzpe3H4lHPVHiShuhaYvKTS1rFVHYwJTjGdUnRqecI49POaxLDuCV3DeCO7JyI1K6ONeHwHDLlKkb5RSXY0Gfa5CQsrW0XCSCtvTZyiI4Nt/M3bKdeYFib8lKRDA7rn3I/p//atAoGBAI1kVLBh4bXY03/VkNPyfxx4h6gAIPsG9vRc3OtwXuQO7DTgj6uW3Ruk443KH4sjJHhWpdHzln19em0KX21NwYTlFKUhX0/GIC7WroCGgPu27h1iNzZLXF5Iwer1cJC0CfLDpmuNrg/BtuHEjf6Mbc5LyelOFZ0X3kjsustUMi/1";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvw9CxkitINE1sHgZtqlB8ow5r/4M2cw1vCiftMD66wDl7R0k760k7F1JtmFDqVRTmwEc7YVTfLkS8vToOn2GwNUeWNQME7dEm3epMGAJOpw3sh0+x4QrBdxtxDfJnyUWpdDASW8YL2K2z8W7QIT5B9fakSSzg7KIJ6DVdJpJCGV78laiUR8nolblh0cN1FeJ0I+tYda7Rp90OPJoJmIWzJp81rjehhFUJcgLtAb6U4IcXXkVNDYrn2kuuI0xU+J+kEbSmDRse6LZ8d3DBYCVT3kgWjQOFCgezLS2JSEatxJ01HG3CsK7Y59nxdgfErUUgycRUMPkuXxIOFnzcQ35kQIDAQAB";
    public static String notify_url = "http://localhost:8888/alipay/alipayNotifyNotice";
    public static String return_url = "http://localhost:8888/alipay/alipayReturnNotice";
    public static String sign_type = "RSA2";
    public static String charset = "utf-8";
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";//注意：沙箱测试环境，正式环境为：https://openapi.alipay.com/gateway.do
}