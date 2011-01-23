
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

package com.java33.example.client.presenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;
import com.java33.example.client.event.ExampleEvent;

import java.util.logging.Logger;

public class ExamplePresenter implements Presenter {
  private static final Logger logger = Logger.getLogger(ExamplePresenter.class.getName());

  public interface Display extends IsWidget {
    HasClickHandlers getButton();

    void setData(String data);
  }

  private final EventBus eventBus;
  private final Display  display;

  @Inject
  public ExamplePresenter(final EventBus eventBus, final Display view) {
    this.eventBus = eventBus;
    display = view;
  }

  protected void bind() {
    display.getButton().addClickHandler(new ClickHandler() {
      public void onClick(final ClickEvent event) {
        logger.fine("The example button was clicked.");
        eventBus.fireEvent((GwtEvent<?>) GWT.create(ExampleEvent.class));
      }
    });
  }

  public void go(final HasWidgets container) {
    bind();
    container.clear();
    container.add(display.asWidget());
  }

  /**
   * Get the presenter's view instance. This method is primarily used by tests.
   *
   * @return Return the presenter's view.
   */
  public Display getDisplay() {
    return display;
  }
}
