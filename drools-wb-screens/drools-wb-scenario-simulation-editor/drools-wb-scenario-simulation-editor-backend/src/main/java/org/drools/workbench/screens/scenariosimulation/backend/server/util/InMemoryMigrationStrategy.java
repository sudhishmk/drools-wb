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

package org.drools.workbench.screens.scenariosimulation.backend.server.util;

import java.util.function.Function;

import org.drools.workbench.screens.scenariosimulation.backend.server.ScenarioSimulationXMLPersistence;
import org.drools.workbench.screens.scenariosimulation.model.ExpressionElement;
import org.drools.workbench.screens.scenariosimulation.model.FactMapping;
import org.drools.workbench.screens.scenariosimulation.model.ScenarioSimulationModel;

public class InMemoryMigrationStrategy implements MigrationStrategy {

    @Override
    public Function<String, String> from1_0to1_1() {
        return rawXml -> rawXml.replaceAll("EXPECTED", "EXPECT").replaceAll("<ScenarioSimulationModel version=\"1.0\">", "<ScenarioSimulationModel version=\"1.1\">");
    }

    @Override
    public Function<String, String> from1_1to1_2() {
        return rawXml -> {
            if ((rawXml.contains("<dmoSession>") || (rawXml.contains("<dmnFilePath>")) && (rawXml.contains("<type>")))) {
                return rawXml.replaceAll("<ScenarioSimulationModel version=\"1.1\">", "<ScenarioSimulationModel version=\"1.2\">");
            } else {
                return rawXml.replaceAll("</simulationDescriptor>", "<dmoSession></dmoSession>\n<type>RULE</type>\n</simulationDescriptor>").replaceAll("<ScenarioSimulationModel version=\"1.1\">", "<ScenarioSimulationModel version=\"1.2\">");
            }
        };
    }

    @Override
    public Function<String, String> from1_2to1_3() {
        return rawXml -> {
            ScenarioSimulationXMLPersistence xmlPersistence = ScenarioSimulationXMLPersistence.getInstance();
            ScenarioSimulationModel model = xmlPersistence.unmarshal(rawXml, false);
            for (FactMapping factMapping : model.getSimulation().getSimulationDescriptor().getUnmodifiableFactMappings()) {
                factMapping.getExpressionElements().add(0, new ExpressionElement(factMapping.getFactIdentifier().getName()));
            }
            return xmlPersistence.marshal(model).replaceAll("<ScenarioSimulationModel version=\"1.2\">", "<ScenarioSimulationModel version=\"1.3\">");
        };
    }

    @Override
    public Function<String, String> from1_3to1_4() {
        return rawXml -> {
            if (rawXml.contains("<type>")) {
                StringBuilder replacementBuilder = new StringBuilder();
                String toReplace = null;
                if (rawXml.contains("<type>RULE</type>")) {
                    toReplace = "<type>RULE</type>";
                    if (!rawXml.contains("<kieSession>")) {
                        replacementBuilder.append("<kieSession>default</kieSession>\n");
                    }
                    if (!rawXml.contains("<kieBase>")) {
                        replacementBuilder.append("<kieBase>default</kieBase>\n");
                    }
                    if (!rawXml.contains("<ruleFlowGroup>")) {
                        replacementBuilder.append("<ruleFlowGroup>default</ruleFlowGroup>\n");
                    }
                    if (!rawXml.contains("<skipFromBuild>")) {
                        replacementBuilder.append("<skipFromBuild>false</skipFromBuild>\n");
                    }
                    replacementBuilder.append("<type>RULE</type>");
                } else  if (rawXml.contains("<type>DMN</type>")) {
                    toReplace = "<type>DMN</type>";
                    if (!rawXml.contains("<dmnNamespace>")) {
                        replacementBuilder.append("<dmnNamespace></dmnNamespace>\n");
                    }
                    if (!rawXml.contains("<dmnName>")) {
                        replacementBuilder.append("<dmnName></dmnName>\n");
                    }
                    if (!rawXml.contains("<skipFromBuild>")) {
                        replacementBuilder.append("<skipFromBuild>false</skipFromBuild>\n");
                    }
                    replacementBuilder.append("<type>DMN</type>");
                }
                String toReturn = rawXml.replaceAll("<ScenarioSimulationModel version=\"1.3\">", "<ScenarioSimulationModel version=\"1.4\">")
                        .replaceAll("<simulationDescriptor>", "<simulationDescriptor>\n  <fileName></fileName>");
                String replacement = replacementBuilder.toString();
                if (toReplace!= null && !toReplace.equals(replacement)) {
                    toReturn = toReturn.replaceAll(toReplace, replacement);
                }
                return toReturn;
            } else {
                return rawXml;
            }
        };
    }
}
