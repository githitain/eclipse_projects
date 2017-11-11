package com.utilites;

public enum LogStatuses 
{
	INFO("[INFO]"),
	DEBUG("[DEBUG]"),
	WARN("[WARN]"),
	ERR("[ERR]");

	private String statusName;

	LogStatuses(String statusName){
		this.statusName = statusName;
	}

	public String getStatusName() {
		return statusName;
	}
}
