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

package com.java33.example.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.*;
import com.google.inject.Inject;
import com.java33.example.client.Messages;
import com.java33.example.client.presenter.ExamplePresenter;

/**
 * Is an example view that implements the ExamplePresenter.Display interface.
 *
 * @author Jon Buffington
 */
public class ExampleView extends Composite implements ExamplePresenter.Display {
  private static final Messages messages = GWT.create(Messages.class);

  private final Button button;

  @Inject
  public ExampleView() {
    final FlowPanel contentPanel = new FlowPanel();
    initWidget(contentPanel);

    contentPanel.add(new Label(messages.label()));
    button = new Button(messages.button());
    contentPanel.add(button);
  }

  public HasClickHandlers getButton() {
    return button;
  }

  @Override
  public Widget asWidget() {
    return this;
  }

  public void setData(String data) {
    button.setText(data);
  }
}
