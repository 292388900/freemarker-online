/*
* Copyright 2011 Kenshoo.com
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.kenshoo.freemarker.dropwizard;

import com.berico.fallwizard.SpringConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.db.DatabaseConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * User: dekely
 * Date: 19/03/13
 * Time: 12:51
 */
public class ApplicationConfiguration extends SpringConfiguration {
    @Valid
    @NotNull
    @JsonProperty
    private DatabaseConfiguration database = new DatabaseConfiguration();

    public void setSystemProperties() {
        System.setProperty("database.password", database.getPassword());
        System.setProperty("database.user", database.getUser());
        System.setProperty("database.url", database.getUrl());
        System.setProperty("database.driverClass", database.getDriverClass());
    }


    public DatabaseConfiguration getDatabaseConfiguration() {
        return database;
    }
}