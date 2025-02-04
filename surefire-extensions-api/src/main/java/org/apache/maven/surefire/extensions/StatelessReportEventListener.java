package org.apache.maven.surefire.extensions;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.maven.surefire.api.report.TestSetReportEntry;

/**
 * Creates a report upon handled event "<em>testSetCompleted</em>".
 * <br>
 * Defaults to <em>org.apache.maven.plugin.surefire.report.StatelessXmlReporter</em>.
 *
 * author <a href="mailto:tibordigana@apache.org">Tibor Digana (tibor17)</a>
 * @since 3.0.0-M4
 * @param <R> report entry type, see <em>WrappedReportEntry</em> from module the <em>maven-surefire-common</em>
 * @param <S> test-set statistics, see <em>TestSetStats</em> from module the <em>maven-surefire-common</em>
 */
public interface StatelessReportEventListener<R extends TestSetReportEntry, S>
{
    /**
     * The callback is called after the test class has been completed and the state of report is final.
     *
     * @param report <em>WrappedReportEntry</em>
     * @param testSetStats <em>TestSetStats</em>
     */
     void testSetCompleted( R report, S testSetStats );

     void allTestSetCompleted();
}
