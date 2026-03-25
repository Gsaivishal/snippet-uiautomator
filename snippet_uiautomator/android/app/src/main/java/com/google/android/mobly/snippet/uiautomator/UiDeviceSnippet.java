/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.mobly.snippet.uiautomator;

import static com.google.common.collect.ImmutableList.toImmutableList;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.mobly.snippet.Snippet;
import com.google.android.mobly.snippet.rpc.Rpc;
import com.google.android.mobly.snippet.rpc.RpcOptional;
import com.google.android.mobly.snippet.uiautomator.Info.PointInfo;
import com.google.android.mobly.snippet.uiautomator.Info.UiDeviceInfo;
import com.google.android.mobly.snippet.uiautomator.Info.UiObject2Info;
import com.google.android.mobly.snippet.uiautomator.selector.Selector;
import com.google.android.mobly.snippet.uiautomator.selector.SelectorException;
import com.google.android.mobly.snippet.util.Log;
import com.google.common.collect.ImmutableList;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * UiDevice snippet class.
 *
 * <p><a
 * href="https://developer.android.com/reference/androidx/test/uiautomator/UiDevice">UiDevice</a>
 */
public class UiDeviceSnippet implements Snippet {

  @Rpc(description = "Performs a click at arbitrary coordinates specified by the user.")
  public boolean click(int x, int y) {
    return UiAutomator.getUiDevice().click(x, y);
  }

  @Rpc(description = "Performs a swipe from one coordinate to another coordinate.")
  public boolean drag(int startX, int startY, int endX, int endY, int steps) {
    return UiAutomator.getUiDevice().drag(startX, startY, endX, endY, steps);
  }

  @Rpc(description = "Dumps the current window hierarchy to a string.")
  public String dump() throws IOException {
    try (OutputStream outputStream = new ByteArrayOutputStream()) {
      UiAutomator.getUiDevice().dumpWindowHierarchy(outputStream);
      return outputStream.toString();
    }
  }

  @Rpc(description = "Returns all objects that match the selector criteria.")
  public ImmutableList<UiObject2Info> findObjects(Selector selector) throws SelectorException {
    return UiAutomator.getUiDevice().findObjects(selector.toBySelector()).stream()
        .map(Info::getUiObject2Info)
        .collect(toImmutableList());
  }

  @Rpc(description = "Disables the sensors and freezes rotation at its current rotation state.")
  public boolean freezeRotation() {
    return tryToExecute(UiAutomator.getUiDevice()::freezeRotation);
  }

  @Rpc(description = "Retrieves the name of the last package to report accessibility events.")
  public String getCurrentPackageName() {
    return UiAutomator.getUiDevice().getCurrentPackageName();
  }

  @Rpc(description = "Gets the height of the display, in pixels.")
  public int getDisplayHeight() {
    return UiAutomator.getUiDevice().getDisplayHeight();
  }

  @Rpc(description = "Returns the current rotation of the display, as defined in Surface.")
  public int getDisplayRotation() {
    return UiAutomator.getUiDevice().getDisplayRotation();
  }

  @Rpc(description = "Returns the display size in dp (device-independent pixel).")
  public PointInfo getDisplaySizeDp() {
    return Info.getPointInfo(UiAutomator.getUiDevice().getDisplaySizeDp());
  }

  @Rpc(description = "Gets the width of the display, in pixels.")
  public int getDisplayWidth() {
    return UiAutomator.getUiDevice().getDisplayWidth();
  }

  @Rpc(description = "Retrieves default launcher package name.")
  public String getLauncherPackageName() {
    return UiAutomator.getUiDevice().getLauncherPackageName();
  }

  @Rpc(description = "Retrieves the product name of the device.")
  public String getProductName() {
    return UiAutomator.getUiDevice().getProductName();
  }

  @Rpc(description = "Returns all properties of device information.")
  public UiDeviceInfo getDevInfo() {
    return Info.getUiDeviceInfo(UiAutomator.getUiDevice());
  }

  @Rpc(description = "Returns whether there is a match for the given selector criteria.")
  public boolean hasObject(Selector selector) throws SelectorException {
    return UiAutomator.getUiDevice().hasObject(selector.toBySelector());
  }

  @Rpc(description = "Checks the power manager if the screen is ON.")
  public boolean isScreenOn() throws RemoteException {
    return UiAutomator.getUiDevice().isScreenOn();
  }

  @Rpc(description = "Opens the notification shade.")
  public boolean openNotification() {
    return UiAutomator.getUiDevice().openNotification();
  }

  @Rpc(description = "Opens the Quick Settings shade.")
  public boolean openQuickSettings() {
    return UiAutomator.getUiDevice().openQuickSettings();
  }

  @Rpc(description = "Simulates a short press on the BACK button.")
  public boolean pressBack() {
    return UiAutomator.getUiDevice().pressBack();
  }

  @Rpc(description = "Simulates a short press on the CENTER button.")
  public boolean pressDPadCenter() {
    return UiAutomator.getUiDevice().pressDPadCenter();
  }

  @Rpc(description = "Simulates a short press on the DOWN button.")
  public boolean pressDPadDown() {
    return UiAutomator.getUiDevice().pressDPadDown();
  }

  @Rpc(description = "Simulates a short press on the LEFT button.")
  public boolean pressDPadLeft() {
    return UiAutomator.getUiDevice().pressDPadLeft();
  }

  @Rpc(description = "Simulates a short press on the RIGHT button.")
  public boolean pressDPadRight() {
    return UiAutomator.getUiDevice().pressDPadRight();
  }

  @Rpc(description = "Simulates a short press on the UP button.")
  public boolean pressDPadUp() {
    return UiAutomator.getUiDevice().pressDPadUp();
  }

  @Rpc(description = "Simulates a short press on the DELETE key.")
  public boolean pressDelete() {
    return UiAutomator.getUiDevice().pressDelete();
  }

  @Rpc(description = "Simulates a short press on the ENTER key.")
  public boolean pressEnter() {
    return UiAutomator.getUiDevice().pressEnter();
  }

  @Rpc(description = "Simulates a short press on the HOME key.")
  public boolean pressHome() {
    return UiAutomator.getUiDevice().pressHome();
  }

  @Rpc(description = "Simulates a short press using a key code.")
  public boolean pressKeyCode(int keyCode, @RpcOptional Integer metaState) {
    return metaState == null
        ? UiAutomator.getUiDevice().pressKeyCode(keyCode)
        : UiAutomator.getUiDevice().pressKeyCode(keyCode, metaState);
  }

  @Rpc(description = "Simulates short press one or more keys using key code.")
  public boolean pressKeyCodes(JSONArray keyCodes, @RpcOptional Integer metaState)
      throws JSONException {
    int[] keyCodeArray = new int[keyCodes.length()];
    for (int i = 0; i < keyCodes.length(); i++) {
      keyCodeArray[i] = keyCodes.getInt(i);
    }
    return metaState == null
        ? UiAutomator.getUiDevice().pressKeyCodes(keyCodeArray)
        : UiAutomator.getUiDevice().pressKeyCodes(keyCodeArray, metaState);
  }

  @Rpc(description = "Simulates a short press on the MENU key.")
  public boolean pressMenu() {
    return UiAutomator.getUiDevice().pressMenu();
  }

  @Rpc(description = "Simulates a short press on the RECENT APPS button.")
  public boolean pressRecentApps() throws RemoteException {
    return UiAutomator.getUiDevice().pressRecentApps();
  }

  @Rpc(description = "Simulates a short press on the SEARCH button.")
  public boolean pressSearch() {
    return UiAutomator.getUiDevice().pressSearch();
  }

  @Rpc(description = "Enables or disables layout hierarchy compression.")
  public void setCompressedLayoutHierarchy(boolean compressed) {
    UiAutomator.getUiDevice().setCompressedLayoutHierarchy(compressed);
  }

  @Rpc(
      description =
          "Simulates orienting the device to the left and also freezes rotation by disabling the"
              + " sensors.")
  public boolean setOrientationLeft() {
    return tryToExecute(UiAutomator.getUiDevice()::setOrientationLeft);
  }

  @Rpc(
      description =
          "Simulates orienting the device into its natural orientation and also freezes rotation by"
              + " disabling the sensors.")
  public boolean setOrientationNatural() {
    return tryToExecute(UiAutomator.getUiDevice()::setOrientationNatural);
  }

  @Rpc(
      description =
          "Simulates orienting the device to the right and also freezes rotation by disabling the"
              + " sensors.")
  public boolean setOrientationRight() {
    return tryToExecute(UiAutomator.getUiDevice()::setOrientationRight);
  }

  @Rpc(
      description =
          "Simulates a short press on the POWER button if the screen is ON, do nothing if the"
              + " screen is already OFF.")
  public boolean sleep() {
    return tryToExecute(UiAutomator.getUiDevice()::sleep);
  }

  @Rpc(description = "Performs a swipe from one coordinate to another.")
  public boolean swipe(int startX, int startY, int endX, int endY, int steps) {
    return UiAutomator.getUiDevice().swipe(startX, startY, endX, endY, steps);
  }

  @Rpc(description = "Performs a swipe between points in the Point array.")
  public boolean swipePoints(JSONArray pointArray, int segmentSteps) throws JSONException {
    final Point[] segments = new Point[pointArray.length()];
    for (int i = 0; i < pointArray.length(); i++) {
      final JSONObject jsonObject = pointArray.getJSONObject(i);
      segments[i] = new Point(jsonObject.getInt("x"), jsonObject.getInt("y"));
    }
    return UiAutomator.getUiDevice().swipe(segments, segmentSteps);
  }

  @Rpc(
      description =
          "Re-enables the sensors and un-freezes the device rotation allowing its contents to"
              + " rotate with the device physical rotation.")
  public boolean unfreezeRotation() {
    return tryToExecute(UiAutomator.getUiDevice()::unfreezeRotation);
  }

  @Rpc(description = "Waits for the current application to idle.")
  public void waitForIdle(long timeoutInMillis) {
    UiAutomator.getUiDevice().waitForIdle(timeoutInMillis);
  }

  @Rpc(description = "Waits for a window content update event to occur.")
  public boolean waitForWindowUpdate(@Nullable String packageName, long timeoutInMillis) {
    return UiAutomator.getUiDevice().waitForWindowUpdate(packageName, timeoutInMillis);
  }

  @Rpc(
      description =
          "Simulates a short press on the POWER button if the screen OFF, do nothing if the screen"
              + " is already ON.")
  public boolean wakeUp() {
    return tryToExecute(UiAutomator.getUiDevice()::wakeUp);
  }

  private interface ThrowingRunnable {
    void run() throws Exception;
  }

  private static boolean tryToExecute(ThrowingRunnable func) {
    try {
      func.run();
      return true;
    } catch (Exception e) {
      Log.e(e);
      return false;
    }
  }

  @Override
  public void shutdown() {}
}
