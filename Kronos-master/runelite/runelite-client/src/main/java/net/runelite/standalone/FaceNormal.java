package net.runelite.standalone;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
public class FaceNormal {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lkn;"
   )
   static Font ItemDefinition_fontPlain11;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lkl;"
   )
   static Buffer NetCache_responseArchiveBuffer;
   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   static Archive archive2;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 149051353
   )
   int x;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2026615431
   )
   int z;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1494841217
   )
   int y;

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "([Lho;IIIZI)V",
      garbageValue = "2028417948"
   )
   static void method2907(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var6.parentId == var1) {
            TileItem.method1607(var6, var2, var3, var4);
            class33.method678(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               GameShell.method1005(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("ki")
   @ObfuscatedSignature(
      signature = "(Lho;II)Ljava/lang/String;",
      garbageValue = "-1147965976"
   )
   static String method2908(Widget var0, int var1) {
      int var3 = class12.method148(var0);
      boolean var2 = (var3 >> var1 + 1 & 1) != 0;
      return !var2 && var0.onOp == null?null:(var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }

   @ObfuscatedName("kr")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Ljava/lang/String;",
      garbageValue = "17"
   )
   static String method2909(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.gameBuild == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.gameBuild == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.gameBuild == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.gameBuild == 5) {
         var0 = var0 + "-wti";
      } else if(Client.gameBuild == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(class197.field2177 != null) {
         var3 = "/p=" + class197.field2177;
      }

      String var4 = "kronos.rip";
      return var2 + var0 + "." + var4 + "/l=" + WorldMapLabelSize.clientLanguage + "/a=" + WorldMapArea.field140 + var3 + "/";
   }
}
