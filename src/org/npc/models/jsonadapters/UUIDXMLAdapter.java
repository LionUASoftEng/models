package org.npc.models.jsonadapters;

import java.util.UUID;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class UUIDXMLAdapter extends XmlAdapter<String, UUID> {
	@Override
	public UUID unmarshal(String v) throws Exception {
		return UUID.fromString(v);
	}

	@Override
	public String marshal(UUID v) throws Exception {
		return v.toString();
	}
}
