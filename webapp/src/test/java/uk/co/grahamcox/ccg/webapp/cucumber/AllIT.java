/****************************************************************************************************************
 * Copyright (c) 2015 OCLC, Inc. All Rights Reserved.
 *
 * OCLC proprietary information: the enclosed materials contain
 * proprietary information of OCLC, Inc. and shall not be disclosed in whole or in
 * any part to any third party or used by any person for any purpose, without written
 * consent of OCLC, Inc.  Duplication of any portion of these materials shall include this notice.
 ******************************************************************************************************************/

package uk.co.grahamcox.ccg.webapp.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Run all of the Integration Tests
 */
@RunWith(Cucumber.class)
@CucumberOptions(tags = {"~@wip", "~@ignore"},
    format = {"pretty"},
    strict = true)
public class AllIT {
}
