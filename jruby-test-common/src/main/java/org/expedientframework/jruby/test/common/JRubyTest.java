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

import org.jruby.RubyObject;
import org.jruby.embed.ScriptingContainer;

/**
 * TODO: Update with a detailed description of the interface/class.
 *
 */
public class JRubyTest
{
  public JRubyTest(final String testMethodName, final RubyObject testClassInstance, final ScriptingContainer container)
  {
    this.testMethodName = testMethodName;
    this.testClassInstance = testClassInstance;
    this.container = container;
  }
  
  public void execute()
  {
    this.container.callMethod(this.testClassInstance, this.testMethodName);
  }
  
  public String getTestName()
  {
    return this.testClassInstance.getMetaClass().getName() + "." + this.testMethodName;
  }
  
  // Private
  private final ScriptingContainer container;
  private final RubyObject testClassInstance;
  private final String testMethodName;
}

