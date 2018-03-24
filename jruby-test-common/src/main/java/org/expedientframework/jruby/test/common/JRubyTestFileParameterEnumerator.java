/********************************************************************
 * File Name:    JRubyTestFileParameterEnumerator.java
 *
 * Date Created: Mar 10, 2018
 *
 * ------------------------------------------------------------------
 * 
 * Copyright (c) 2018 ajeydudhe@gmail.com
 *
 *******************************************************************/

package org.expedientframework.jruby.test.common;
  
/**
 * TODO: Update with a detailed description of the interface/class.
 *
 */
public class JRubyTestFileParameterEnumerator extends TestFileParameterEnumerator
{
  public JRubyTestFileParameterEnumerator(final String rootFolder, final String[] filePatterns)
  {
    super(rootFolder, filePatterns);
  }

  public JRubyTestFileParameterEnumerator()
  {
    this("./src/test/ruby", new String[] {".*test\\.rb", ".*tests\\.rb"});
  }
}

