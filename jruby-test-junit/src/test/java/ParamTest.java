import org.expedientframework.jruby.test.common.JRubyTestParameter;
import org.expedientframework.jruby.test.junit.common.AbstractJRubyTest;

/********************************************************************
 * File Name:    ParamTest.java
 *
 * Date Created: Mar 10, 2018
 *
 * ------------------------------------------------------------------
 * 
 * Copyright (c) 2018 ajeydudhe@gmail.com
 *
 *******************************************************************/

public class ParamTest extends AbstractJRubyTest
{
  /*
  @Parameters(name="{0}")
  public static JRubyTestFileParameterEnumerator data()
  {
    return new JRubyTestFileParameterEnumerator("dummy", new String[] {""});
  }*/
  
  public ParamTest(final JRubyTestParameter jrubyTest)
  {
    super(jrubyTest);
  }
}

