package com.ahut.cones.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtUtil {
	//���ܵ���Կ
	private String SECRET = "www.xianxinghsuo.com-2019.06.29";
	private String header = "token";
	private String accessClam = "USERIDACCESSKEY";
	/*
	 * ����JWT token
	 * 
	 * */
	public String createToken(String userId) {
		Map<String, Object> headerMap = new HashMap<>();
		headerMap.put("alg", "HS256");
		headerMap.put("typ", "JWT");
		String token = null;
		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("userId", userId);
			jsonObject.put(accessClam, accessClam);
			token = JWT.create().withHeader(headerMap)
					.withClaim(accessClam, jsonObject.toJSONString())
					.withIssuedAt(new Date())
					.sign(Algorithm.HMAC256(SECRET));
		} catch (Exception e) {
			log.info(e.getMessage());
		} 
		return token;
	}
	/*
	 * ����JWT token
	 * 
	 * */
	public Map<String,Claim> verifyToken(String token) throws Exception {
		JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
		DecodedJWT jwt = null;
		try {
			jwt = verifier.verify(token);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return jwt.getClaims();
	}
	
	/*
	 * JWT token  to  userId
	 * 
	 * */
	public Long tokenToUserId(String token) throws Exception {
		if (StringUtils.isEmpty(token)) {
			throw new Exception("token cannot be empty");
		}
		JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
		DecodedJWT jwt = null;
		Long userId = null;
		try {
			jwt = verifier.verify(token);
			userId = Long.valueOf(jwt.getClaims().get("userId").asString());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return userId;
	}
	
	/*
	 * 判断 token 是否过期
	 * */
	public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }
	
	public String getHeader() {
		return header;
	}
	
	public String getAccessClam() {
		return accessClam;
	}
}
