/*
 * Copyright (c) 2011 Jon Buffington. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.java33.example.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.java33.example.client.cdi.AppInjector;

import java.util.logging.Logger;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 *
 * @author Jon Buffington
 */
public class Example implements EntryPoint {

  private static final Logger logger = Logger.getLogger(Example.class.getName());

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    final AppInjector injector = GWT.create(AppInjector.class);
    final AppController appController = injector.getAppController();

    logger.fine("Starting the GWT unit test example app.");

    appController.go(RootLayoutPanel.get());
  }
}
