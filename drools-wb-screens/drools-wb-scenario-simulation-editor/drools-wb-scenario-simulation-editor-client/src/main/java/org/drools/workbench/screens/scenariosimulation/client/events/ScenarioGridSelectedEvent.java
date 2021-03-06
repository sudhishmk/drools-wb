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
package org.drools.workbench.screens.scenariosimulation.client.events;

import java.util.Optional;

import org.drools.workbench.screens.scenariosimulation.client.editor.ScenarioSimulationEditorPresenter;
import org.kie.soup.commons.validation.PortablePreconditions;

public class ScenarioGridSelectedEvent {

    private final Optional<ScenarioSimulationEditorPresenter> scenarioSimulationEditorPresenter;
    private final boolean isLockRequired;

    public ScenarioGridSelectedEvent(final ScenarioSimulationEditorPresenter scenarioSimulationEditorPresenter) {
        this(scenarioSimulationEditorPresenter,
             true);
    }

    public ScenarioGridSelectedEvent(final ScenarioSimulationEditorPresenter scenarioSimulationEditorPresenter,
                                     final boolean isLockRequired) {
        this.scenarioSimulationEditorPresenter = Optional.of(PortablePreconditions.checkNotNull("scenarioSimulationEditorPresenter",
                                                                                                scenarioSimulationEditorPresenter));
        this.isLockRequired = isLockRequired;
    }

    public static ScenarioGridSelectedEvent NONE = new ScenarioGridSelectedEvent();

    private ScenarioGridSelectedEvent() {
        scenarioSimulationEditorPresenter = Optional.empty();
        isLockRequired = false;
    }

    public Optional<ScenarioSimulationEditorPresenter> getPresenter() {
        return scenarioSimulationEditorPresenter;
    }

    public boolean isLockRequired() {
        return isLockRequired;
    }
}
