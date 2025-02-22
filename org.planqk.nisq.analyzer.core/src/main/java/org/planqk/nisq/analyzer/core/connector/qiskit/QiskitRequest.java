/*******************************************************************************
 * Copyright (c) 2021 University of Stuttgart
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
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
 *******************************************************************************/

package org.planqk.nisq.analyzer.core.connector.qiskit;

import java.net.URL;
import java.util.Map;

import org.planqk.nisq.analyzer.core.model.ParameterValue;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class QiskitRequest {

    @Getter
    @Setter
    @JsonProperty("impl-url")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private URL impl_url;

    @Getter
    @Setter
    @JsonProperty(value = "impl-language")
    private String impl_language;

    @Getter
    @Setter
    @JsonProperty(value = "impl-data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String impl_data;

    @Getter
    @Setter
    @JsonProperty("qpu-name")
    private String qpu_name;

    @Getter
    @Setter
    @JsonProperty(value = "transpiled-qasm")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String transpiled_qasm;

    @Getter
    @Setter
    @JsonProperty("input-params")
    private Map<String, ParameterValue> input_params;

    @Getter
    @Setter
    @JsonProperty(value = "bearer-token")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String bearerToken;

    public QiskitRequest(URL impl_url, String impl_language, String qpu_name, Map<String, ParameterValue> input_params, String bearerToken) {
        this.impl_url = impl_url;
        this.impl_language = impl_language;
        this.qpu_name = qpu_name;
        this.input_params = input_params;
        this.bearerToken = bearerToken;
    }

    public QiskitRequest(String impl_language, String impl_data, String qpu_name, Map<String, ParameterValue> input_params) {
        this.impl_language = impl_language;
        this.impl_data = impl_data;
        this.qpu_name = qpu_name;
        this.input_params = input_params;
    }

    public QiskitRequest(String transpiled_qasm, String qpu_name, Map<String, ParameterValue> input_params) {
        this.transpiled_qasm = transpiled_qasm;
        this.qpu_name = qpu_name;
        this.input_params = input_params;
    }

    public QiskitRequest(String impl_data, String impl_language) {
        this.impl_data = impl_data;
        this.impl_language = impl_language;
    }
}
