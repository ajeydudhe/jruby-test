/********************************************************************
 * File Name:    FileEnumeratorTest.java
 *
 * Date Created: Mar 9, 2018
 *
 * ------------------------------------------------------------------
 * 
 * Copyright (c) 2018 ajeydudhe@gmail.com
 *
 *******************************************************************/

package org.expedientframework.jruby.test.common;

import static org.assertj.core.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;

public class FileEnumeratorTest
{
  @Test
  public void file_pattern_match_test()
  {
    final FileEnumerator fileEnumerator = new FileEnumerator("./src/test/dummy_files", new String[] {".*test.rb", ".*tests.rb"});
    
    final List<String> returnedFiles = new ArrayList<>();

    for (File file : fileEnumerator)
    {
      returnedFiles.add(file.getName());
    }
    
    assertThat(returnedFiles).containsExactly("CalculatorTest.rb", "SomeCalculatorTests.rb", "caltest.rb", "dummy_test.rb", "SampleTest.rb", "SomeDummyTests.rb");
  }
}

