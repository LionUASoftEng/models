package org.npc.models.enums;

import java.util.HashMap;
import java.util.Map;


public enum TransactionApiRequestStatus {
	
	OK(0),
	INVALID_INPUT(1),
	UNKNOWN_ERROR(2),
	LOOKUP_CODE_ALREADY_EXISTS(3);
	
	public int getValue() {
		return value;
	}

	public static TransactionApiRequestStatus map(int key) {
		if (valueMap == null) {
			valueMap = new HashMap<Integer, TransactionApiRequestStatus>();

			for (TransactionApiRequestStatus status : TransactionApiRequestStatus.values()) {
				valueMap.put(status.getValue(), status);
			}
		}
		
		return (valueMap.containsKey(key) ? valueMap.get(key) : TransactionApiRequestStatus.UNKNOWN_ERROR);
	}
	
	private int value;

	private static Map<Integer, TransactionApiRequestStatus> valueMap = null;

	private TransactionApiRequestStatus(int value) {
		this.value = value;
	}

}
