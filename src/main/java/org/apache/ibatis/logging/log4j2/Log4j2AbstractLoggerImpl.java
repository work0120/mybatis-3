/*
 *    Copyright 2013 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.logging.log4j2;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.message.SimpleMessage;
import org.apache.logging.log4j.spi.AbstractLogger;
import org.apache.logging.log4j.spi.AbstractLoggerWrapper;

/**
 * @author Eduardo Macarron
 */
public class Log4j2AbstractLoggerImpl extends AbstractLogger implements Log {
  
  private static Marker MARKER = MarkerManager.getMarker(LogFactory.MARKER);
  
  private static final String FQCN = Log4j2Impl.class.getName();
  
  private AbstractLoggerWrapper log;

  public Log4j2AbstractLoggerImpl(AbstractLogger abstractLogger) {
    log = new AbstractLoggerWrapper(abstractLogger, abstractLogger.getName(), abstractLogger.getMessageFactory());
  }

  public boolean isDebugEnabled() {
    return log.isDebugEnabled();
  }

  public boolean isTraceEnabled() {
    return log.isTraceEnabled();
  }

  public void error(String s, Throwable e) {
    log(MARKER, FQCN, Level.ERROR, new SimpleMessage(s), e);
  }

  public void error(String s) {
    log(MARKER, FQCN, Level.ERROR, new SimpleMessage(s), null);
  }

  public void debug(String s) {
    log(MARKER, FQCN, Level.DEBUG, new SimpleMessage(s), null);
  }

  public void trace(String s) {
    log(MARKER, FQCN, Level.TRACE, new SimpleMessage(s), null);
  }

  public void warn(String s) {
    log(MARKER, FQCN, Level.WARN, new SimpleMessage(s), null);
  }
  
  
  @Override
	protected boolean isEnabled(Level level, Marker marker, Message data,
			Throwable t) {
		
		return false;
	}


	@Override
	protected boolean isEnabled(Level level, Marker marker, Object data,
			Throwable t) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	protected boolean isEnabled(Level level, Marker marker, String data) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	protected boolean isEnabled(Level level, Marker marker, String data,
			Object... p1) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	protected boolean isEnabled(Level level, Marker marker, String data,
			Throwable t) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void log(Marker marker, String fqcn, Level level, Message data,
			Throwable t) {
		log.log(level, marker, data, t);
		
	}

  

}
