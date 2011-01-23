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


import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;
import com.java33.example.client.cdi.AppInjector;
import com.java33.example.client.event.ExampleEvent;
import com.java33.example.client.presenter.Presenter;

/**
 * Coordinate the application's various presenters using GWT's History support.
 * The Activity and Places support in GWT 2.1 would be a better choice for a
 * larger application.
 *
 * @author Jon Buffington
 */
public class AppController implements Presenter, ValueChangeHandler<String> {
  private static final String DEFAULT_TOKEN = "default";
  private static final String EXAMPLE_TOKEN = "example";
  private final EventBus    eventBus;
  private final AppInjector injector;
  private       HasWidgets  container;

  @Inject
  public AppController(final EventBus eventBus, final AppInjector injector) {
    this.eventBus = eventBus;
    this.injector = injector;
    bind();
  }

  /**
   * Bind handlers to the application's events.
   */
  private void bind() {
    History.addValueChangeHandler(this);

    eventBus.addHandler(ExampleEvent.TYPE, new ExampleEvent.ExampleEventHandler() {
      public void onExample(final ExampleEvent event) {
        doExample();
      }
    });

  }

  private void doExample() {
    History.newItem(EXAMPLE_TOKEN);
  }

  /**
   * Capture the desired container and pump the history value.
   */
  public void go(final HasWidgets container) {
    this.container = container;

    if ("".equals(History.getToken())) {
      History.newItem(DEFAULT_TOKEN);
    }
    else {
      History.fireCurrentHistoryState();
    }
  }

  /**
   * Delegate the application state handling to the appropriate presenter.
   */
  public void onValueChange(final ValueChangeEvent<String> event) {
    final String token = event.getValue();

    if (token != null) {
      Presenter presenter = null;

      if (token.equals(DEFAULT_TOKEN)) {
        presenter = injector.getExamplePresenter();
      }
      else if (token.equals(EXAMPLE_TOKEN)) {
        presenter = injector.getExamplePresenter();
      }

      if (presenter != null) {
        // Pass the container to the current presenter.
        presenter.go(container);
      }
    }
  }
}
