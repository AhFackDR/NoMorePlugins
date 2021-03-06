/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package plugin.nomore.aiomarkers;

import net.runelite.client.config.*;
import plugin.nomore.aiomarkers.npc.NPCRenderStyle;

import java.awt.Color;

@ConfigGroup("aiomarkers")
public interface AIOConfig extends Config
{

	String ANSI_RESET = "\u001B[0m";
	String ANSI_BLACK = "\u001B[30m";
	String ANSI_RED = "\u001B[31m";
	String ANSI_GREEN = "\u001B[32m";
	String ANSI_YELLOW = "\u001B[33m";
	String ANSI_BLUE = "\u001B[34m";
	String ANSI_PURPLE = "\u001B[35m";
	String ANSI_CYAN = "\u001B[36m";
	String ANSI_WHITE = "\u001B[37m";

	@ConfigTitleSection(
			keyName = "configurationOptions",
			name = "Configuration Options",
			description = "",
			position = 1
	)
	default Title configurationOptions()
	{
		return new Title();
	}

	@ConfigItem(
			keyName = "markerConfiguration",
			name = "for:",
			description = "",
			position = 2,
			titleSection = "configurationOptions"
	)
	default ConfigurationOptions markerConfiguration() { return ConfigurationOptions.NPC_HIGHLIGHTING; }

	//███╗   ██╗██████╗  ██████╗
	//████╗  ██║██╔══██╗██╔════╝
	//██╔██╗ ██║██████╔╝██║
	//██║╚██╗██║██╔═══╝ ██║
	//██║ ╚████║██║     ╚██████╗
	//╚═╝  ╚═══╝╚═╝      ╚═════╝

	@ConfigItem(
			keyName = "npcHighlightTitle",
			name = "NPC Highlight Options",
			description = "",
			position = 10,
			hidden = true,
			unhide = "markerConfiguration",
			unhideValue = "NPC_HIGHLIGHTING"
	)
	default Title npcHighlightTitle()
	{
		return new Title();
	}

	@ConfigItem(
			keyName = "enableNPCHighlighting",
			name = "Enable NPC Highlight",
			description = "",
			position = 11,
			hidden = true,
			unhide = "markerConfiguration",
			unhideValue = "NPC_HIGHLIGHTING"
	)
	default boolean enableNPCHighlighting() { return false; }

	@ConfigItem(
			keyName = "npcRenderStyle",
			name = "Render style",
			description = "The type of marker.",
			position = 12,
			hidden = true,
			unhide = "markerConfiguration",
			unhideValue = "NPC_HIGHLIGHTING"
	)
	default NPCRenderStyle npcRenderStyle() { return NPCRenderStyle.BOX; }

	@ConfigItem(
			keyName = "npcIndicatorSize",
			name = "Indicator size",
			description = "The size of the marker.",
			position = 13,
			hidden = true,
			unhide = "markerConfiguration",
			unhideValue = "NPC_HIGHLIGHTING"
	)
	default int npcIndicatorSize() { return 4; }

	@ConfigItem(
			keyName = "configNPCTextField",
			name = "NPC Name / ID:Hex Color",
			description = "Example: \"Goblin:00FF00,\".",
			position = 14,
			hidden = true,
			unhide = "markerConfiguration",
			unhideValue = "NPC_HIGHLIGHTING"
	)
	default String npcConfigTextString() { return "Banker, 3010"; }

	@ConfigItem(
			keyName = "npcColorTitle",
			name = "Indicator Interaction Color Options",
			description = "",
			position = 15,
			unhide = "markerConfiguration",
			unhideValue = "NPC_HIGHLIGHTING"
	)
	default Title npcColorTitle()
	{
		return new Title();
	}

	@ConfigItem(
			keyName = "npcDefaultHighlightColor",
			name = "Default Marker color",
			description = "The default color for the NPC indicator.",
			position = 16,
			hidden = true,
			unhide = "markerConfiguration",
			unhideValue = "NPC_HIGHLIGHTING"
	)
	default Color npcDefaultHighlightColor() { return Color.GREEN; }

	@ConfigItem(
			keyName = "npcEnableNPCDefaultColorOverrideWithNPCInteractingWithPlayer",
			name = "Enable NPC -> Player Indicator",
			description = "Enable the override of the default NPC highlighting color should the NPC be attacking your player.",
			position = 17,
			hidden = true,
			unhide = "markerConfiguration",
			unhideValue = "NPC_HIGHLIGHTING"
	)
	default boolean npcEnableNPCDefaultColorOverrideWithNPCInteractingWithPlayer() { return false; }

	@ConfigItem(
			keyName = "npcInteractingWithPlayerColor",
			name = "NPC -> Player color",
			description = "The color of the indicator.",
			position = 18,
			hidden = true,
			unhide = "markerConfiguration",
			unhideValue = "NPC_HIGHLIGHTING"
	)
	default Color npcInteractingWithPlayerColor() { return Color.YELLOW; }

	@ConfigItem(
			keyName = "npcEnableNPCDefaultColorOverrideWithPlayersInteractingWithPlayer",
			name = "Enable Players -> NPC Indicator",
			description = "Enable the override of the default NPC highlighting color should another player be attacking an NPC that is currently marked.",
			position = 19,
			hidden = true,
			unhide = "markerConfiguration",
			unhideValue = "NPC_HIGHLIGHTING"
	)
	default boolean npcEnableNPCDefaultColorOverrideWithPlayersInteractingWithPlayer() { return false; }

	@ConfigItem(
			keyName = "npcPlayersInteractingWithNPCColor",
			name = "Players -> NPC color",
			description = "The color of the indicator.",
			position = 20,
			hidden = true,
			unhide = "markerConfiguration",
			unhideValue = "NPC_HIGHLIGHTING"
	)
	default Color npcPlayersInteractingWithNPCColor() { return Color.RED; }

	@ConfigItem(
			keyName = "npcEnableHighlightingMenuItemForMarkedNPCS",
			name = "Enable Menu Highlighting",
			description = "Enable the highlighting of the NPC's name context menu.",
			position = 21,
			hidden = true,
			unhide = "markerConfiguration",
			unhideValue = "NPC_HIGHLIGHTING"
	)
	default boolean npcEnableHighlightingMenuItemForMarkedNPCS() { return false; }

	@ConfigItem(
			keyName = "npcMenuItemColorForMarkedNPCS",
			name = "Menu Item Color",
			description = "The color of the menu item.",
			position = 22,
			hidden = true,
			unhide = "markerConfiguration",
			unhideValue = "NPC_HIGHLIGHTING"
	)
	default Color npcMenuItemColorForMarkedNPCS() { return Color.MAGENTA; }

	@ConfigItem(
			keyName = "npc10",
			name = "",
			description = "",
			position = 23,
			hidden = true,
			unhide = "markerConfiguration",
			unhideValue = "NPC_HIGHLIGHTING"
	)
	default Title npc11() { return new Title(); }

	@ConfigItem(
			keyName = "npcMiscOptionsTitle",
			name = "Miscellaneous Options",
			description = "",
			position = 24,
			hidden = true,
			unhide = "markerConfiguration",
			unhideValue = "NPC_HIGHLIGHTING"
	)
	default Title npcMiscOptionsTitle()
	{
		return new Title();
	}

	@ConfigItem(
			keyName = "npc10",
			name = "",
			description = "",
			position = 25,
			hidden = true,
			unhide = "markerConfiguration",
			unhideValue = "NPC_HIGHLIGHTING"
	)
	default Title npc10()
	{
		return new Title();
	}

	@ConfigItem(
			keyName = "npcLineOfSight",
			name = "Only show NPC's you can \"see\"",
			description = "",
			position = 26,
			hidden = true,
			unhide = "markerConfiguration",
			unhideValue = "NPC_HIGHLIGHTING"
	)
	default boolean npcLineOfSight() { return false; }

	@ConfigItem(
			keyName = "npcDisplayMouseHoveringIndicator",
			name = "Mouse hovering indicator",
			description = "If enabled will display an indicator if hovering over the npc.",
			position = 27,
			hidden = true,
			unhide = "markerConfiguration",
			unhideValue = "NPC_HIGHLIGHTING"
	)
	default boolean npcDisplayMouseHoveringIndicator() { return false; }

	@ConfigItem(
			keyName = "npcMouseHoveringIndicatorLocation",
			name = "X:Y:Width:Height indicator location",
			description = "If enabled will display an indicator if hovering over the npc.",
			position = 28,
			hidden = true,
			unhide = "markerConfiguration",
			unhideValue = "NPC_HIGHLIGHTING"
	)
	default String npcMouseHoveringIndicatorLocation() { return "10:10:10:10"; }

}