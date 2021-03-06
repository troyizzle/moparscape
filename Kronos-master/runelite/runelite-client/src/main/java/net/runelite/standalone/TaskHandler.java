package net.runelite.standalone;

import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class TaskHandler implements Runnable {
   @ObfuscatedName("n")
   public static String javaVersion;
   @ObfuscatedName("z")
   public static String javaVendor;
   @ObfuscatedName("ah")
   protected static boolean hasFocus;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   static AbstractArchive Widget_modelsArchive;
   @ObfuscatedName("p")
   boolean isClosed;
   @ObfuscatedName("r")
   Thread thread;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   Task task;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   Task current;

   public TaskHandler() {
      this.current = null;
      this.task = null;
      this.isClosed = false;
      javaVendor = "Unknown";
      javaVersion = "1.6";

      try {
         javaVendor = System.getProperty("java.vendor");
         javaVersion = System.getProperty("java.version");
      } catch (Exception var2) {
         ;
      }

      this.isClosed = false;
      this.thread = new Thread(this);
      this.thread.setPriority(10);
      this.thread.setDaemon(true);
      this.thread.start();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;S)Lfv;",
      garbageValue = "255"
   )
   final Task method3417(int var1, int var2, int var3, Object var4) {
      Task var5 = new Task();
      var5.type = var1;
      var5.intArgument = var2;
      var5.objectArgument = var4;
      synchronized(this) {
         if(this.task != null) {
            this.task.next = var5;
            this.task = var5;
         } else {
            this.task = this.current = var5;
         }

         this.notify();
      }

      return var5;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lfv;",
      garbageValue = "-1627707278"
   )
   public final Task method3427(Runnable var1, int var2) {
      return this.method3417(2, var2, 0, var1);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Lfv;",
      garbageValue = "2091612218"
   )
   public final Task method3418(String var1, int var2) {
      return this.method3417(1, var2, 0, var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1673059069"
   )
   public final void method3416() {
      synchronized(this) {
         this.isClosed = true;
         this.notifyAll();
      }

      try {
         this.thread.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public final void run() {
      while(true) {
         Task var1;
         synchronized(this) {
            while(true) {
               if(this.isClosed) {
                  return;
               }

               if(this.current != null) {
                  var1 = this.current;
                  this.current = this.current.next;
                  if(this.current == null) {
                     this.task = null;
                  }
                  break;
               }

               try {
                  this.wait();
               } catch (InterruptedException var8) {
                  ;
               }
            }
         }

         try {
            int var5 = var1.type;
            if(var5 == 1) {
               var1.result = new Socket(InetAddress.getByName((String)var1.objectArgument), var1.intArgument);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.objectArgument);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.intArgument);
               var1.result = var3;
            } else if(var5 == 4) {
               var1.result = new DataInputStream(((URL)var1.objectArgument).openStream());
            }

            var1.status = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.status = 2;
         }
      }
   }

   @ObfuscatedName("z")
   static double method3415(double var0, double var2, double var4) {
      double var8 = (var0 - var2) / var4;
      double var6 = Math.exp(-var8 * var8 / 2.0D) / Math.sqrt(6.283185307179586D);
      return var6 / var4;
   }
}
