/*
 * Copyright 2019 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.workbench.screens.scenariosimulation.backend.server.runner.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ResultWrapperTest {

    @Test
    public void orElse() {
        assertEquals((Integer) 1, ResultWrapper.createResult(1).orElse(3));
        assertEquals(3, ResultWrapper.createErrorResult().orElse(3));
        assertNull(ResultWrapper.createResult(null).orElse(3));
    }

    @Test
    public void orElseGet() {
        assertEquals((Integer) 1, ResultWrapper.createResult(1).orElseGet(() -> 3));
        assertEquals(3, ResultWrapper.createErrorResult().orElseGet(() -> 3));
        assertNull(ResultWrapper.createResult(null).orElseGet(() -> 3));
    }
}