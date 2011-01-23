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

package com.java33.example.client.application;

import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.ui.Button;
import com.java33.example.client.cdi.AppInjector;
import com.java33.example.client.presenter.ExamplePresenter;

/**
 * Is an example Application (GWTTestCase) application test class.
 * <p>Note: The file avoids the default "GwtTest_.java" naming pattern
 * to avoid being run by the default plugin configuration as this test
 * case is included in the GwtTestSuite.</p>
 */
public class ExampleGwtTC extends GWTTestCase {
  private ExamplePresenter presenter;

  /**
   * Return the fully-qualified name of the GWT module. This is the glue
   * that tells the GWTTestCase runner which GWT module to use.
   *
   * @see com.google.gwt.junit.client.GWTTestCase#getModuleName()
   */
  public String getModuleName() {
    return "com.java33.example.ExampleTestModule";
  }

  @Override
  public void gwtSetUp() {
    final AppInjector injector = GWT.create(AppInjector.class);
    presenter = injector.getExamplePresenter();
  }

  /**
   * Furiously test the button.
   */
  public void testButton() {
    final ExamplePresenter.Display display = presenter.getDisplay();
    assertNotNull(display);
    final Button button = (Button) display.getButton();
    assertNotNull(button);
    assertTrue("The display's button is using an unexpected label.", button.getText().equals("Example"));
  }

}
