package me.yanjobs;


import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.concurrent.TimeUnit;

@Mod(modid = PitQuickMath.MODID, version = PitQuickMath.VERSION)
public class PitQuickMath {
    public static final String MODID = "autotipplus"; //hiding as autotipplus
    public static final String VERSION = "1.0";


    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event) {
        String quickMathMessage = event.message.getUnformattedText();
        System.out.println(quickMathMessage);
        if (quickMathMessage.contains("&r&d&lQUICK MATHS! &r&7Solve: &r&e")) {
            String expression = quickMathMessage.substring(quickMathMessage.lastIndexOf("&e") +2 , quickMathMessage.lastIndexOf("&r"));
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("JavaScript");
            expression = expression.replace("x", "*");
            try {
                Object result = engine.eval(expression);
                String finalResult = result.toString();
                TimeUnit.MILLISECONDS.sleep((long) (Math.random() * (3000 - 1000 + 1) + 1000));
                Minecraft.getMinecraft().thePlayer.sendChatMessage(finalResult);
            } catch (ScriptException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

}
