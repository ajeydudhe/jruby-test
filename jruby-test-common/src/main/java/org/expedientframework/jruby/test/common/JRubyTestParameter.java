/********************************************************************
 * File Name:    JRubyTestParameter.java
 *
 * Date Created: Mar 24, 2018
 *
 * ------------------------------------------------------------------
 * 
 * Copyright (c) 2018 ajeydudhe@gmail.com
 *
 *******************************************************************/

package org.expedientframework.jruby.test.common;

import org.expedientframework.jcommon.test.TestParameter;

/**
 * TODO: Update with a detailed description of the interface/class.
 *
 */
public class JRubyTestParameter extends TestParameter<JRubyTest>
{
  public JRubyTestParameter(final JRubyTest jrubyTest)
  {
    super(jrubyTest.getTestName(), jrubyTest);
  }
}

