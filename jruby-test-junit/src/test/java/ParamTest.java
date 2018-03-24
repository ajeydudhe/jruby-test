import static org.junit.Assert.*;

import java.io.File;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.expedientframework.jruby.test.common.FileEnumerator;
import org.expedientframework.jruby.test.common.FileParameter;
import org.expedientframework.jruby.test.common.JRubyTestFileParameterEnumerator;
import org.expedientframework.jruby.test.common.TestFileParameterEnumerator;
import org.expedientframework.jruby.test.common.TestParameter;
import org.expedientframework.jruby.test.common.TestParameterEnumerator;
import org.expedientframework.jruby.test.junit.common.AbstractJRubyTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

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
  
  public ParamTest(final FileParameter file)
  {
    super(file);
  }
}

