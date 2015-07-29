/****************************************************************************************************************
 * Copyright (c) 2015 OCLC, Inc. All Rights Reserved.
 *
 * OCLC proprietary information: the enclosed materials contain
 * proprietary information of OCLC, Inc. and shall not be disclosed in whole or in
 * any part to any third party or used by any person for any purpose, without written
 * consent of OCLC, Inc.  Duplication of any portion of these materials shall include this notice.
 ******************************************************************************************************************/

package uk.co.grahamcox.ccg.webapp.cucumber.steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Steps for working with Users
 */
public class UsersSteps extends StepBase {
    /**
     * Attempt to get the user details of the currently logged in user
     */
    @When("^I get the details of the current user$")
    public void getCurrentUser() {
        throw new PendingException();
    }

    /**
     * Attempt to get the user details of a specific user
     * @param userId the ID of the user to get
     */
    @When("^I get the details of the user \"(.+)\"$")
    public void getSpecificUser(String userId) {
        throw new PendingException();
    }

    /**
     * Verify that we successfully retrieved a user
     */
    @Then("^the user details are successfully returned$")
    public void verifyUserReturnedSuccessfully() {
        throw new PendingException();
    }

    /**
     * Verify that we got a Not Found from retrieving a user
     */
    @Then("^the user details are not found$")
    public void verifyUserNotFound() {
        throw new PendingException();
    }

    /**
     * Verify that the user we retrieved has the correct data
     * @param dataTable the data to expect
     */
    @Then("^the user details look like:$")
    public void assertReturnedUser(DataTable dataTable) {
        throw new PendingException();
    }
}
