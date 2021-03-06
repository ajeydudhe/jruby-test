/********************************************************************
 * File Name:    CalculatorTest.java
 *
 * Date Created: Mar 26, 2018
 *
 * ------------------------------------------------------------------
 * 
 * Copyright (c) 2018 ajeydudhe@gmail.com
 *
 *******************************************************************/

package org.expedientframework.calculator;

import org.expedientframework.jruby.test.common.JRubyTestParameter;
import org.expedientframework.jruby.test.common.JRubyTestParameterEnumerator;
import org.expedientframework.jruby.test.junit.common.AbstractJRubyTest;
import org.junit.runners.Parameterized.Parameters;

public class CalculatorTest extends AbstractJRubyTest
{
  @Parameters(name="{0}") // This controls the display name of the test.
  public static JRubyTestParameterEnumerator data()
  {
    return new JRubyTestParameterEnumerator("./src/test/ruby/calculator/raw_tests");
  }
  
  public CalculatorTest(final JRubyTestParameter jrubyTest)
  {
    super(jrubyTest);
  }
}

