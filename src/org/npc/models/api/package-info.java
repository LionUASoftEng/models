@XmlJavaTypeAdapters({
    @XmlJavaTypeAdapter(type=LocalDateTime.class, value=LocalDateTimeXMLAdapter.class),
    @XmlJavaTypeAdapter(type=UUID.class, value=UUIDXMLAdapter.class)
})

package org.npc.models.api;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

import org.npc.models.jsonadapters.LocalDateTimeXMLAdapter;
import org.npc.models.jsonadapters.UUIDXMLAdapter;
