package me.yanjobs.pitquickmathslunar.commands;

import net.weavemc.loader.api.command.Command;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class HelloCommand extends Command {
    public HelloCommand() {
        super("pitquickmaths", "hi", "test");
    }
    public void handle(String[] args) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Hi :)"));
    }
}
