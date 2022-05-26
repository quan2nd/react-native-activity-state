package com.reactnativeactivitystate;

import static com.facebook.react.bridge.UiThreadUtil.runOnUiThread;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;

@ReactModule(name = ActivityStateModule.NAME)
public class ActivityStateModule extends ReactContextBaseJavaModule implements LifecycleObserver {
  public static final String NAME = "ActivityState";
  ReactApplicationContext mReactContext;

  public ActivityStateModule(ReactApplicationContext reactContext) {
    super(reactContext);

    mReactContext = reactContext;
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        initLifecycle();
      }
    });
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  private void initLifecycle() {
    ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_START)
  private void onMoveToForeground() {
    if (mReactContext != null && mReactContext.hasCurrentActivity()) {
      getReactApplicationContext()
        .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
        .emit("onMoveToForeground", null);
    }
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  private void onMoveToBackground() {
    if (mReactContext != null && mReactContext.hasCurrentActivity()) {
      getReactApplicationContext()
        .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
        .emit("onMoveToBackground", null);
    }
  }
}
