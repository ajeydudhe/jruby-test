/********************************************************************
 * File Name:    AbstractJRubyTest.java
 *
 * Date Created: Mar 10, 2018
 *
 * ------------------------------------------------------------------
 * 
 * Copyright (c) 2018 ajeydudhe@gmail.com
 *
 *******************************************************************/

package org.expedientframework.jruby.test.junit.common;

import org.expedientframework.jruby.test.common.JRubyTestParameter;
import org.expedientframework.jruby.test.common.JRubyTestParameterEnumerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public abstract class AbstractJRubyTest
{
  @Parameters(name="{0}")
  public static JRubyTestParameterEnumerator data()
  {
    return new JRubyTestParameterEnumerator();
  }
  
  protected AbstractJRubyTest(final JRubyTestParameter jrubyTest)
  {
    this.jrubyTest = jrubyTest;
  }
  
  @Test
  public void $()
  {
    this.jrubyTest.getData().execute();
  }
  
  // protected
  protected final JRubyTestParameter jrubyTest;
}

