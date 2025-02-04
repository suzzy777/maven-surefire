package org.apache.maven.surefire.common.junit4;

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

import org.apache.maven.surefire.api.report.ReportEntry;
import org.apache.maven.surefire.api.report.RunListener;
import org.apache.maven.surefire.api.report.RunMode;
import org.apache.maven.surefire.api.report.TestSetReportEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Internal tests use only.
 */
final class MockReporter
    implements RunListener
{
    private final List<String> events = new ArrayList<>();

    private static final String SET_STARTED = "SET_STARTED";

    private static final String SET_COMPLETED = "SET_COMPLETED";

    private static final String TEST_STARTED = "TEST_STARTED";

    private static final String TEST_COMPLETED = "TEST_COMPLETED";

    private static final String TEST_SKIPPED = "TEST_SKIPPED";

    private final AtomicInteger testSucceeded = new AtomicInteger();

    private final AtomicInteger testIgnored = new AtomicInteger();

    private final AtomicInteger testFailed = new AtomicInteger();

    private final AtomicInteger testError = new AtomicInteger();

    MockReporter()
    {
    }

    @Override
    public void allTestSetCompleted()
    {
    }

    @Override
    public void testSetStarting( TestSetReportEntry report )
    {
        events.add( SET_STARTED );
    }

    @Override
    public void testSetCompleted( TestSetReportEntry report )
    {
        events.add( SET_COMPLETED );
    }

    @Override
    public void testStarting( ReportEntry report )
    {
        events.add( TEST_STARTED );
    }

    @Override
    public void testSucceeded( ReportEntry report )
    {
        events.add( TEST_COMPLETED );
        testSucceeded.incrementAndGet();
    }

    @Override
    public void testSkipped( ReportEntry report )
    {
        events.add( TEST_SKIPPED );
        testIgnored.incrementAndGet();
    }

    @Override
    public void testExecutionSkippedByUser()
    {
    }

    @Override
    public RunMode markAs( RunMode currentRunMode )
    {
        return null;
    }

    public int getTestSucceeded()
    {
        return testSucceeded.get();
    }

    public int getTestFailed()
    {
        return testFailed.get();
    }

    @Override
    public void testError( ReportEntry report )
    {
        testError.incrementAndGet();
    }

    @Override
    public void testFailed( ReportEntry report )
    {
        testFailed.incrementAndGet();
    }

    @Override
    public void testAssumptionFailure( ReportEntry report )
    {
    }
}
