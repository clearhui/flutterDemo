package com.clear.hui;

import android.app.Activity;
import android.os.Binder;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import io.flutter.Log;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;


public class BasePulgin implements ActivityAware, FlutterPlugin, MethodChannel.MethodCallHandler {
    FlutterPluginBinding flutterPluginBinding;
    ActivityPluginBinding activityPluginBinding;
    MethodChannel methodChannel;


    @Override
    public void onAttachedToActivity(@NonNull ActivityPluginBinding binding) {

    }

    @Override
    public void onDetachedFromActivityForConfigChanges() {

    }

    @Override
    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding binding) {

    }

    @Override
    public void onDetachedFromActivity() {
        try{// try 解决Attempt to invoke virtual method 'void io.flutter.plugin.common.h.lI(io.flutter.plugin.common.h$b)' on a null object reference
            methodChannel.setMethodCallHandler(null);
        }catch (Exception e){
            Log.e("eee",e.getStackTrace().toString());
        }
        methodChannel=null;
    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result) {
        if (call.method.startsWith("getData")) {
            int type = (int) call.arguments;
            Log.e("result", result.toString() + "====" + type);
            result.success("huihui");
        }
    }


    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding binding) {
        flutterPluginBinding = binding;
        methodChannel=new MethodChannel(binding.getBinaryMessenger(),"clear_hui");
        methodChannel.setMethodCallHandler(this);
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    }
}
