package com.lietou.util;

import java.util.Base64;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lietou.dto.LoginDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

public class TokenMgr {

    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getEncoder().encode("wusiweijwt".getBytes());
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * 签发JWT
     * @param id
     * @param subject
     * @param ttlMillis
     * @return
     * @throws Exception
     */
    public static String createJWT(String id, String subject, long ttlMillis) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        SecretKey secretKey = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setSubject(subject)
                .setIssuedAt(now)
                .signWith(signatureAlgorithm, secretKey);
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate);
        }
        return builder.compact();
    }

    /**
     * 验证JWT
     * @param jwtStr
     * @return
     */
    public static CheckResult validateJWT(String jwtStr) {
        CheckResult checkResult = new CheckResult();
        Claims claims = null;
        try {
            claims = parseJWT(jwtStr);
            checkResult.setSuccess(true);
            checkResult.setClaims(claims);
        } catch (ExpiredJwtException e) {
        //    checkResult.setErrCode(Constant.JWT_ERRCODE_EXPIRE);
            checkResult.setSuccess(false);
        } catch (SignatureException e) {
        //    checkResult.setErrCode(Constant.JWT_ERRCODE_FAIL);
            checkResult.setSuccess(false);
        } catch (Exception e) {
        //    checkResult.setErrCode(Constant.JWT_ERRCODE_FAIL);
            checkResult.setSuccess(false);
        }
        return checkResult;
    }

    /**
     * 
     * 解析JWT字符串
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
            .setSigningKey(secretKey)
            .parseClaimsJws(jwt)
            .getBody();
    }

    /**
     * 生成subject信息
     * @param user
     * @return
     */
    public static String generalSubject(LoginDto sub){
        return JSON.toJSONString(sub);
    }
    
    public static void main(String[] args) {
    	try {
			Claims c=parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2MiIsInN1YiI6IntcImlkXCI6NjIsXCJqd3RcIjpcIlwiLFwib0lkXCI6MjgsXCJ1c2VybmFtZVwiOlwid3VzaXdlaTFcIn0iLCJpYXQiOjE1NzkxMzQzODYsImV4cCI6MTU3OTk5ODM4Nn0.otYZxLnqxXuriA6LjVUFrfT8E8faArdLa48HbWhEgnU");
			System.out.println(c.getId());
			LoginDto user =JSONObject.parseObject(c.getSubject(), LoginDto.class);
			System.out.println(user.getUsername());
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}