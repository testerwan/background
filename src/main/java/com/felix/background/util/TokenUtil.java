package com.felix.background.util;


import com.felix.background.entity.User;

/**
 * @author felix
 */
public class TokenUtil {

    //token到期时间60s
    private static final long EXPIRE_TIME = 60 * 1000;

    public static final String TOKEN_SECRET = "bMc4zT87kP5x4nFPD3oj";

    public static String sign(User user) {
        String token = null;
//        try {
//            Date expireAt=new Date(System.currentTimeMillis()+EXPIRE_TIME);
//            token = JWT.create()
//                    //发行人
//                    .withIssuer("auth0")
//                    //存放数据
//                    .withClaim("username",user.getUsername())
//                    .withClaim("id",user.getId())
//                    .withClaim("name",user.getName())
//                    //过期时间
//                    .withExpiresAt(expireAt)
//                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
//        } catch (IllegalArgumentException | JWTCreationException je) {
//
//        }
        return token;
    }

    /**
     * 对token进行验证
     *
     * @param token
     * @return
     */
    public static Boolean verify(String token) {
//        try {
//            //创建token验证器
//            JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
//            DecodedJWT decodedJWT=jwtVerifier.verify(token);
//            System.out.println("认证通过：");
//            System.out.println("username: " + TokenUtil.getUserName(token));
//            System.out.println("过期时间：    " + decodedJWT.getExpiresAt());
//        } catch (IllegalArgumentException | JWTVerificationException e) {
//            //抛出错误即为验证不通过
//            return false;
//        }
        return true;
    }

    /**
     * 获取用户名
     */
    public static String getUserName(String token) {
//        try{
//            DecodedJWT jwt=JWT.decode(token);
//            return  jwt.getClaim("username").asString();
//        }catch (JWTDecodeException e)
//        {
//            return null;
//        }
        return null;
    }
}
