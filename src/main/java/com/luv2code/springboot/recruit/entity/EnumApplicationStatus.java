package com.luv2code.springboot.recruit.entity;

public enum EnumApplicationStatus {
	APPLIED, INVITED, REJECTED, HIRED;
	
	public static EnumApplicationStatus getApplicationStatusByName(String name) {
		for (EnumApplicationStatus e : EnumApplicationStatus.values()) {
			if (e.name().equals(name)) {
				return e;
			}
		}
		return null;
	}
}