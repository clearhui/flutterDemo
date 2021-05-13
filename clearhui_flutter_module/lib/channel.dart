
import 'package:flutter/services.dart';

class CommonChannels {
  EventChannel _eventChannel;

  static MethodChannel _methodChannel=MethodChannel("clear_hui");

   static Future<String> getData(int type) async{
     String userName = await _methodChannel.invokeMethod("getData",type);
   return  userName;
   }

}