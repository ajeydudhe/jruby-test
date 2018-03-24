/********************************************************************
 * File Name:    TestFileParameterEnumerator.java
 *
 * Date Created: Mar 10, 2018
 *
 * ------------------------------------------------------------------
 * 
 * Copyright (c) 2018 ajeydudhe@gmail.com
 *
 *******************************************************************/

package org.expedientframework.jruby.test.common;

import java.io.File;

/**
 * TODO: Update with a detailed description of the interface/class.
 *
 */
public class TestFileParameterEnumerator extends TestParameterEnumerator<File>
{
  public TestFileParameterEnumerator(final String rootFolder, final String...filePatterns)
  {
    this(new FileEnumerator(rootFolder, filePatterns));
  }

  public TestFileParameterEnumerator(final FileEnumerator fileEnumerator)
  {
    super(fileEnumerator, file -> new FileParameter(file));
  }
}

