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

import android.app.Instrumentation;
import android.app.UiAutomation;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;

/** Initialize UiAutomator when starting Mobly Snippet service. */
public class UiAutomator {
  private static final Instrumentation instrumentation =
      InstrumentationRegistry.getInstrumentation();
  private static UiAutomation uiAutomation;
  private static UiDevice uiDevice;

  public static synchronized UiAutomation getUiAutomation() {
    if (uiAutomation == null) {
      uiAutomation = instrumentation.getUiAutomation();
    }
    return uiAutomation;
  }

  public static synchronized UiDevice getUiDevice() {
    if (uiDevice == null) {
      uiDevice = UiDevice.getInstance(instrumentation);
    }
    return uiDevice;
  }

  private UiAutomator() {}
}
