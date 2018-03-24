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

import org.expedientframework.jruby.test.common.FileParameter;
import org.expedientframework.jruby.test.common.JRubyTestFileParameterEnumerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public abstract class AbstractJRubyTest
{
  @Parameters(name="{0}")
  public static JRubyTestFileParameterEnumerator data()
  {
    return new JRubyTestFileParameterEnumerator();
  }
  
  protected AbstractJRubyTest(final FileParameter fileParameter)
  {
    this.fileParameter = fileParameter;
  }
  
  @Test
  public void $()
  {
    System.out.println(this.fileParameter.getData());
  }
  
  // protected
  protected final FileParameter fileParameter;
}

