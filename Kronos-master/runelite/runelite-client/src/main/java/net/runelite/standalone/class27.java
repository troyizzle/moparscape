package net.runelite.standalone;

import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("aj")
public class class27 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;B)Ljava/lang/Object;",
      garbageValue = "-1"
   )
   public static Object method539(Applet var0, String var1) throws Throwable {
      return JSObject.getWindow(var0).call(var1, (Object[])null);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;I)V",
      garbageValue = "-716931956"
   )
   public static void method538(Applet var0, String var1) throws Throwable {
      JSObject.getWindow(var0).eval(var1);
   }
}
