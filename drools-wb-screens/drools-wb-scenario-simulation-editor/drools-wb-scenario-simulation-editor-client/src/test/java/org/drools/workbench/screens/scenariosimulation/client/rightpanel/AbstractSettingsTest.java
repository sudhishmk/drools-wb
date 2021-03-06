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

package org.drools.workbench.screens.scenariosimulation.client.rightpanel;

import com.google.gwt.dom.client.ButtonElement;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.LabelElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.Style;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

abstract class AbstractSettingsTest {

    protected final String SCENARIO_TYPE = "SCENARIO_TYPE";

    protected static final String FILE_NAME = "FILE_NAME";
    protected static final String KIE_SESSION = "KIE_SESSION";
    protected static final String KIE_BASE = "KIE_BASE";
    protected static final String RULE_FLOW_GROUP = "RULE_FLOW_GROUP";
    protected static final String DMO_SESSION = "DMO_SESSION";
    protected static final String DMN_FILE_PATH = "DMN_FILE_PATH";
    protected static final String DMN_NAMESPACE = "DMN_NAMESPACE";
    protected static final String DMN_NAME = "DMN_NAME";

    @Mock
    protected LabelElement nameLabelMock;

    @Mock
    protected SpanElement fileNameMock;

    @Mock
    protected LabelElement typeLabelMock;

    @Mock
    protected SpanElement scenarioTypeMock;

    @Mock
    protected DivElement ruleSettingsMock;


    @Mock
    protected Style ruleSettingsStyleMock;

    @Mock
    protected InputElement kieSessionMock;

    @Mock
    protected InputElement kieBaseMock;

    @Mock
    protected InputElement ruleFlowGroupMock;

    @Mock
    protected InputElement dmoSessionMock;

    @Mock
    protected DivElement dmnSettingsMock;

    @Mock
    protected Style dmnSettingsStyleMock;

    @Mock
    protected LabelElement dmnModelLabelMock;

    @Mock
    protected SpanElement dmnFilePathMock;

    @Mock
    protected LabelElement dmnNamespaceLabelMock;

    @Mock
    protected SpanElement dmnNamespaceMock;

    @Mock
    protected LabelElement dmnNameLabelMock;

    @Mock
    protected SpanElement dmnNameMock;

    @Mock
    protected InputElement skipFromBuildMock;

    @Mock
    protected ButtonElement saveButtonMock;

    protected void setup() {
        when(scenarioTypeMock.getInnerText()).thenReturn(SCENARIO_TYPE);
        when(fileNameMock.getInnerText()).thenReturn(FILE_NAME);
        when(scenarioTypeMock.getInnerText()).thenReturn(SCENARIO_TYPE);
        when(kieSessionMock.getValue()).thenReturn(KIE_SESSION);
        when(kieBaseMock.getValue()).thenReturn(KIE_BASE);
        when(ruleFlowGroupMock.getValue()).thenReturn(RULE_FLOW_GROUP);
        when(dmoSessionMock.getValue()).thenReturn(DMO_SESSION);
        when(dmnFilePathMock.getInnerText()).thenReturn(DMN_FILE_PATH);
        when(dmnNamespaceMock.getInnerText()).thenReturn(DMN_NAMESPACE);
        when(dmnNameMock.getInnerText()).thenReturn(DMN_NAME);
        when(ruleSettingsMock.getStyle()).thenReturn(ruleSettingsStyleMock);
        when(dmnSettingsMock.getStyle()).thenReturn(dmnSettingsStyleMock);
    }
}