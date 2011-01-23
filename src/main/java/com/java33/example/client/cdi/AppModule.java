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

package com.java33.example.client.cdi;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;
import com.java33.example.client.presenter.ExamplePresenter;
import com.java33.example.client.view.ExampleView;

public class AppModule extends AbstractGinModule {

  @Override
  protected void configure() {
    // Support injecting the HandlerManager into the Application scope.
    bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);

    // Bind the each com.java33.example.client.presenter's display to an instance of its UI view.
    bind(ExamplePresenter.Display.class).to(ExampleView.class);
  }

}
