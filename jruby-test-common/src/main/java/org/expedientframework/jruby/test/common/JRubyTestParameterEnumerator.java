/********************************************************************
 * File Name:    JRubyTestParameterEnumerator.java
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

import org.expedientframework.jcommon.io.FileEnumerator;
import org.expedientframework.jcommon.test.TestParameter;

/**
 * TODO: Update with a detailed description of the interface/class.
 *
 */
public class JRubyTestParameterEnumerator implements Iterable<TestParameter<JRubyTest>>
{
  public JRubyTestParameterEnumerator(final String rootFolder, final String[] filePatterns)
  {
    this.rootFolder = rootFolder;
    this.filePatterns = filePatterns;
  }

  public JRubyTestParameterEnumerator()
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
      this.fileIterator = new FileEnumerator(rootFolder, filePatterns).iterator();
      this.jrubyTestIterator = getJRubyTestIterator();
    }
    
    @Override
    public boolean hasNext()
    {
      if(this.jrubyTestIterator == null)
         return false;
      
      if(this.jrubyTestIterator.hasNext() == false)
      {
        this.jrubyTestIterator = getJRubyTestIterator();
      }
      
      return (this.jrubyTestIterator != null ? this.jrubyTestIterator.hasNext() : false);
    }

    @Override
    public TestParameter<JRubyTest> next()
    {
      // Should not get called if hasNext() returns false.
      final JRubyTest jrubyTest = this.jrubyTestIterator.next();
      return new JRubyTestParameter(jrubyTest); // TODO: Ajey_Dudhe - Form a good test name
    }
    
    private Iterator<JRubyTest> getJRubyTestIterator()
    {
      while(this.fileIterator.hasNext())
      {
        final JRubyTests jrubyTests = new JRubyTests(this.fileIterator.next());
        final Iterator<JRubyTest> jrubyTestIterator = jrubyTests.iterator();
        if(jrubyTestIterator.hasNext())
        {
          return jrubyTestIterator;
        }
      }
      return null;
    }

    // Private members
    private final Iterator<File> fileIterator;
    private Iterator<JRubyTest> jrubyTestIterator;
  }
}

