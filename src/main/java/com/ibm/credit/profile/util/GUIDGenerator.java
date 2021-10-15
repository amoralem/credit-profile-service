package com.ibm.credit.profile.util;

import java.util.UUID;

public final class GUIDGenerator {
	
	private GUIDGenerator() {}
	
	public static final String generateGUID() {
		
        return UUID.randomUUID().toString();
	}
	
	
}
