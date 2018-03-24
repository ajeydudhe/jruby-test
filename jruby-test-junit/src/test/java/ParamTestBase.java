import static org.junit.Assert.*;

import java.io.File;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.expedientframework.jruby.test.common.FileEnumerator;
import org.expedientframework.jruby.test.common.JRubyTestFileParameterEnumerator;
import org.expedientframework.jruby.test.common.TestFileParameterEnumerator;
import org.expedientframework.jruby.test.common.TestParameter;
import org.expedientframework.jruby.test.common.TestParameterEnumerator;
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

@RunWith(Parameterized.class)
public class ParamTestBase
{
  @Parameters(name="{0}")
  public static TestParameterEnumerator<File> data()
  {
    //final FileEnumerator fileEnumerator = new FileEnumerator("./src/test/dummy_files", new String[] {".*test.rb", ".*tests.rb"});
    //return new TestFileParameterEnumerator("./src/test/dummy_files", new String[] {".*test.rb", ".*tests.rb"});
    return new JRubyTestFileParameterEnumerator();
  }
  
  public ParamTestBase(final TestParameter<File> file)
  {
    this.file = file.getData();
  }
  
  @Test
  public void my_test_method()
  {
    System.out.println(String.format("Called test with [%s]", this.file));
  }

  // Private
  private File file;
}

