/********************************************************************
 * File Name:    TestParameter.java
 *
 * Date Created: Mar 10, 2018
 *
 * ------------------------------------------------------------------
 * 
 * Copyright (c) 2018 ajeydudhe@gmail.com
 *
 *******************************************************************/

package org.expedientframework.jcommon.test;
  
/**
 * TODO: Update with a detailed description of the interface/class.
 *
 */
public class TestParameter<T>
{
  public TestParameter(final String name, final T data)
  {
    this.name = name;
    this.data = data;
  }
  
  public T getData()
  {
    return this.data;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  @Override
  public String toString()
  {
    return this.getName();
  }
  
  // Protected
  private final String name;
  private final T data;
}

