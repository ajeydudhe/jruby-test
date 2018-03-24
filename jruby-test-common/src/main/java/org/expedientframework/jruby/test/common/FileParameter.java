/********************************************************************
 * File Name:    FileParameter.java
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
public class FileParameter extends TestParameter<File>
{
  public FileParameter(final File file)
  {
    super(file.getName(), file);
  }
}

