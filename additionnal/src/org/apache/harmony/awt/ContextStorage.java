/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
/**
 * @author Pavel Dolgov
 * @version $Revision$
 */
package org.apache.harmony.awt;

import java.awt.*;

import org.apache.harmony.awt.datatransfer.*;
import org.apache.harmony.awt.internal.nls.Messages;


public final class ContextStorage {

    private volatile boolean shutdownPending = false;

    private static final ContextStorage globalContext = new ContextStorage();

    private Toolkit toolkit;
    private DTK dtk;
    private GraphicsEnvironment graphicsEnvironment;

    private class ContextLock {}
    private final Object contextLock = new ContextLock();
  
  
    public static void setDefaultToolkit(Toolkit newToolkit) {
        // TODO: checkPermission

        getCurrentContext().toolkit = newToolkit;
    }

    public static Toolkit getDefaultToolkit() {
        return getCurrentContext().toolkit;
    }

    public static void setDTK(DTK dtk) {
        // TODO: checkPermission
        getCurrentContext().dtk = dtk;
    }

    public static DTK getDTK() {
        return getCurrentContext().dtk;
    }

    public static Object getContextLock() {
        return getCurrentContext().contextLock;
    }

    public static GraphicsEnvironment getGraphicsEnvironment() {
        return getCurrentContext().graphicsEnvironment;
    }

    public static void setGraphicsEnvironment(GraphicsEnvironment environment) {
        getCurrentContext().graphicsEnvironment = environment;
    }

    private static ContextStorage getCurrentContext() {
        return globalContext;
    }

    public static boolean shutdownPending() {
        return getCurrentContext().shutdownPending;
    }

    void shutdown() {
        
    }
}
