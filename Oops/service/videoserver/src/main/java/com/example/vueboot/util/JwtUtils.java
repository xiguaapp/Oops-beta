package com.example.vueboot.util;

import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;
/**
 * @author helen
 * @since 2019/10/16
 */
public class JwtUtils {

    private static String SECRET = "token!Q@W#E$R";

    /**
     * 生产token
     */
    public static String getToken(Map<String, String> map) {
        JWTCreator.Builder builder = JWT.create();

        //payload
        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7); //默认7天过期

        builder.withExpiresAt(instance.getTime());//指定令牌的过期时间
        String token = builder.sign(Algorithm.HMAC256(SECRET));//签名
        return token;
    }

    /**
     * 验证token
     */
    public static DecodedJWT verify(String token) {
        //如果有任何验证异常，此处都会抛出异常
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
        return decodedJWT;
    }

//    /**
//     * 获取token中的 payload
//     */
//    public static DecodedJWT getToken(String token) {
//        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
//        return decodedJWT;
//    }
//
//    public static final long EXPIRE = 1000 * 60 * 60 * 24;
//    public static final String APP_SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO";
//
//    public static String getJwtToken(String id, String nickname){
//        String JwtToken = Jwts.builder()
//                .setHeaderParam("typ", "JWT")
//                .setHeaderParam("alg", "HS256")
//                .setSubject("guli-user")
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
//                .claim("id", id)
//                .claim("nickname", nickname)
//                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
//                .compact();
//
//        return JwtToken;
//    }
//    /**
//     * 判断token是否存在与有效
//     * @param jwtToken
//     * @return
//     */
//    public static boolean checkToken(String jwtToken) {
//        if(StringUtils.isEmpty(jwtToken)) return false;
//        try {
//            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
//
//    /**
//     * 判断token是否存在与有效
//     * @param request
//     * @return
//     */
//    public static boolean checkToken(HttpServletRequest request) {
//        try {
//            String jwtToken = request.getHeader("token");
//            if(StringUtils.isEmpty(jwtToken)) return false;
//            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
//
//    /**
//     * 根据token获取会员id
//     * @param request
//     * @return
//     */
//    public static String getMemberIdByJwtToken(HttpServletRequest request) {
//        String jwtToken = request.getHeader("token");
//        if(StringUtils.isEmpty(jwtToken)) return "";
//        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
//        Claims claims = claimsJws.getBody();
//        return (String)claims.get("id");
//    }
}
