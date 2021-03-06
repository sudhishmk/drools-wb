/*
 * Copyright 2018 Red Hat, Inc. and/or its affiliates.
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class to group all runner data: given data, expected data and results
 */
public class ScenarioRunnerData {

    private final List<ScenarioGiven> givens = new ArrayList<>();
    private final List<ScenarioExpect> expects = new ArrayList<>();
    private final List<ScenarioResult> results = new ArrayList<>();

    public void addGiven(ScenarioGiven input) {
        givens.add(input);
    }

    public void addExpect(ScenarioExpect output) {
        expects.add(output);
    }

    public void addResult(ScenarioResult result) {
        results.add(result);
    }

    public List<ScenarioGiven> getGivens() {
        return Collections.unmodifiableList(givens);
    }

    public List<ScenarioExpect> getExpects() {
        return Collections.unmodifiableList(expects);
    }

    public List<ScenarioResult> getResults() {
        return Collections.unmodifiableList(results);
    }
}
