/********************************************************************
 * File Name:    JRubyTest.java
 *
 * Date Created: Mar 24, 2018
 *
 * ------------------------------------------------------------------
 * 
 * Copyright (c) 2018 ajeydudhe@gmail.com
 *
 *******************************************************************/

package org.expedientframework.jruby.test.common;

import org.jruby.RubyClass;
import org.jruby.RubyObject;
import org.jruby.embed.ScriptingContainer;

/**
 * TODO: Update with a detailed description of the interface/class.
 *
 */
public class JRubyTest
{
  public JRubyTest(final String testMethodName, final RubyClass testClass, final ScriptingContainer container)
  {
    this.testMethodName = testMethodName;
    this.testClass = testClass;
    this.container = container;
  }
  
  public void execute()
  {
    // TODO: Ajey_Dudhe - Need to provide flexibility to use same instance for all the tests similar to TestNG.
    // Currently, we are creating the instance per test.
    this.container.callMethod(this.testClass.callMethod("new"), this.testMethodName);
  }
  
  public String getTestName()
  {
    return this.testClass.getName() + "." + this.testMethodName;
  }
  
  // Private
  private final ScriptingContainer container;
  private final RubyClass testClass;
  private final String testMethodName;
}

