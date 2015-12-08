package org.npc.models.commands.interfaces;

public interface ResultCommandInterface<TResult> {
	TResult execute();
}