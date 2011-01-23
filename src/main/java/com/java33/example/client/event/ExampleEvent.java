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

package com.java33.example.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.EventHandler;

import com.google.inject.Inject;

public class ExampleEvent extends GwtEvent<ExampleEvent.ExampleEventHandler> {
  public interface ExampleEventHandler extends EventHandler {
    void onExample(ExampleEvent event);
  }

  public static Type<ExampleEvent.ExampleEventHandler> TYPE = new Type<ExampleEvent.ExampleEventHandler>();

  @Inject
  public ExampleEvent() {
    super();
  }

  @Override
  public Type<ExampleEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(final ExampleEventHandler handler) {
    handler.onExample(this);
  }
}
