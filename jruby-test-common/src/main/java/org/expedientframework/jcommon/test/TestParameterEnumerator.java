/********************************************************************
 * File Name:    TestParameterEnumerator.java
 *
 * Date Created: Mar 10, 2018
 *
 * ------------------------------------------------------------------
 * 
 * Copyright (c) 2018 ajeydudhe@gmail.com
 *
 *******************************************************************/

package org.expedientframework.jcommon.test;

import java.util.Iterator;
import java.util.function.Function;

public class TestParameterEnumerator<T> implements Iterable<TestParameter<T>>
{
  public TestParameterEnumerator(final Iterable<T> source, final Function<T, TestParameter<T>> convertor) 
  {
    this.source = source;
    this.convertor = convertor;
  }
  
  @Override
  public Iterator<TestParameter<T>> iterator()
  {
    return new TestParameterIterator();
  }

  // Private
  private final Iterable<T> source;
  private final Function<T, TestParameter<T>> convertor;
  
  private class TestParameterIterator implements Iterator<TestParameter<T>>
  {
    public TestParameterIterator()
    {
      this.sourceIterator = source.iterator();
    }
    
    @Override
    public boolean hasNext()
    {
      return this.sourceIterator.hasNext();
    }

    @Override
    public TestParameter<T> next()
    {
      return convertor.apply(this.sourceIterator.next());
    }
    
    // Private
    private final Iterator<T> sourceIterator;
  }
}

