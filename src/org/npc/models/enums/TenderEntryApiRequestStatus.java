package org.npc.models.enums;

import java.util.HashMap;
import java.util.Map;

public enum TenderEntryApiRequestStatus {
	OK(0),
	INVALID_INPUT(1),
	UNKNOWN_ERROR(2),
	LOOKUP_CODE_ALREADY_EXISTS(3);
	
	public int getValue() {
		return value;
	}

	public static TenderEntryApiRequestStatus map(int key) {
		if (valueMap == null) {
			valueMap = new HashMap<Integer, TenderEntryApiRequestStatus>();

			for (TenderEntryApiRequestStatus status : TenderEntryApiRequestStatus.values()) {
				valueMap.put(status.getValue(), status);
			}
		}
		
		return (valueMap.containsKey(key) ? valueMap.get(key) : TenderEntryApiRequestStatus.UNKNOWN_ERROR);
	}
	
	private int value;

	private static Map<Integer, TenderEntryApiRequestStatus> valueMap = null;

	private TenderEntryApiRequestStatus(int value) {
		this.value = value;
	}
}
