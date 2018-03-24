/********************************************************************
 * File Name:    JRubyTestEnumerator.java
 *
 * Date Created: Mar 24, 2018
 *
 * ------------------------------------------------------------------
 * 
 * Copyright (c) 2018 ajeydudhe@gmail.com
 *
 *******************************************************************/

package org.expedientframework.jruby.test.common;

import java.io.File;
import java.util.Iterator;

/**
 * TODO: Update with a detailed description of the interface/class.
 *
 */
public class JRubyTestEnumerator implements Iterable<TestParameter<JRubyTest>>
{
  public JRubyTestEnumerator(final String rootFolder, final String[] filePatterns)
  {
    this.rootFolder = rootFolder;
    this.filePatterns = filePatterns;
  }

  public JRubyTestEnumerator()
  {
    this("./src/test/ruby", new String[] {".*test\\.rb", ".*tests\\.rb"});
  }

  @Override
  public Iterator<TestParameter<JRubyTest>> iterator()
  {
    return new JRubyTestIterator();
  }

  // Private members
  private final String rootFolder;
  private final String[] filePatterns;
  
  // TODO: Ajey_Dudhe - Need to create a generic implementation which has two iterators connected.
  private class JRubyTestIterator implements Iterator<TestParameter<JRubyTest>>
  {
    public JRubyTestIterator()
    {
      this.jrubyTestFileParameterIterator = new JRubyTestFileParameterEnumerator(rootFolder, filePatterns).iterator();
    }
    
    @Override
    public boolean hasNext()
    {
      // TODO: Ajey_Dudhe - Revisit !!! If the test file does not have any tests then this will not work.
      return this.jrubyTestFileParameterIterator.hasNext();
    }

    @Override
    public TestParameter<JRubyTest> next()
    {
      return null;
    }
    
    // Private members
    private final Iterator<TestParameter<File>> jrubyTestFileParameterIterator;
  }
}

