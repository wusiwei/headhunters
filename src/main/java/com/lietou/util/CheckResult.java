package com.lietou.util;

import io.jsonwebtoken.Claims;

public class CheckResult {
	private boolean success;
	
	private Claims claims;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Claims getClaims() {
		return claims;
	}

	public void setClaims(Claims claims) {
		this.claims = claims;
	}
	
	
}
