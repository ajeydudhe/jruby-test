/********************************************************************
 * File Name:    JRubyTests.java
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jruby.RubyClass;
import org.jruby.RubyObject;
import org.jruby.embed.ScriptingContainer;
import org.jruby.runtime.Visibility;

/**
 * TODO: Update with a detailed description of the interface/class.
 *
 */
class JRubyTests implements Iterable<JRubyTest>
{
  public JRubyTests(final File testFile)
  {
    this.testFile = testFile;
  }
  
  @Override
  public Iterator<JRubyTest> iterator()
  {
    final List<JRubyTest> jrubyTests = new ArrayList<>();
        
    final RubyClass testClass = getTestClassInstance(this.testFile);
    testClass.getMethods().forEach( (testMethodName, definition) -> {
     
      // TODO: Ajey_Dudhe - Need to provide flexibility in defining test methods e.g. starting with test_* etc.
      if(definition.getVisibility() == Visibility.PUBLIC) {
        
        jrubyTests.add(new JRubyTest(testMethodName, testClass, container));
      }
    });
    
    return jrubyTests.iterator();
  }

  private RubyClass getTestClassInstance(final File file)
  {
    final String className = file.getName().replaceAll(".rb", "");

    return (RubyClass) container.runScriptlet(String.format("require '%s'\n%s", file.getAbsolutePath(), className));    
  }
  
  // Private
  private final ScriptingContainer container = new ScriptingContainer(); // TODO: Ajey_Dudhe - Revisit !!! ctor params and can it be static !!!
  private final File testFile;
}

