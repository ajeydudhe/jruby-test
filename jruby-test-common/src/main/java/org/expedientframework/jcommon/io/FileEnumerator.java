/********************************************************************
 * File Name:    FileEnumerator.java
 *
 * Date Created: Mar 7, 2018
 *
 * ------------------------------------------------------------------
 * 
 * Copyright (c) 2018 ajeydudhe@gmail.com
 *
 *******************************************************************/

package org.expedientframework.jcommon.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Simple file enumerator to list files recursively.
 * 
 * @author ajey_dudhe
 *
 */
public class FileEnumerator implements Iterable<File>
{
  public FileEnumerator(final String rootFolder, final String...filePatterns)
  {
    this.rootFolder = rootFolder;
    
    for (String pattern : filePatterns)
    {
      this.filePatterns.add(Pattern.compile(pattern, Pattern.CASE_INSENSITIVE));
    }
  }
  
  public Iterator<File> iterator()
  {
    return new FileIterator();
  }
  
  private final String rootFolder;
  private final List<Pattern> filePatterns = new ArrayList<>();
  
  public class FileIterator implements Iterator<File>
  {
    private FileIterator() 
    {
      try
      {
        this.pathIterator = Files.find(Paths.get(rootFolder), Integer.MAX_VALUE, 
                                       (filePath, attributes) -> attributes.isRegularFile(), 
                                       FileVisitOption.FOLLOW_LINKS)
                                 .filter(path -> {
                                   
                                    for (Pattern filePattern : filePatterns)
                                    {
                                      if(filePattern.matcher(path.getFileName().toString()).matches())
                                         return true;
                                    }
                                   return false;
                                 }) 
                                 .iterator();
      }
      catch (IOException e)
      {
        throw new RuntimeException(e); // TODO: ajey_dudhe - Throw custom exception !!!
      }
    }
    
    public boolean hasNext()
    {
      return this.pathIterator.hasNext();
    }

    public File next()
    {
      return this.pathIterator.next().toFile();
    }
    
    // Private
    private final Iterator<Path> pathIterator;
  }
}

