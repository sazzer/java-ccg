/****************************************************************************************************************
 * Copyright (c) 2015 OCLC, Inc. All Rights Reserved.
 *
 * OCLC proprietary information: the enclosed materials contain
 * proprietary information of OCLC, Inc. and shall not be disclosed in whole or in
 * any part to any third party or used by any person for any purpose, without written
 * consent of OCLC, Inc.  Duplication of any portion of these materials shall include this notice.
 ******************************************************************************************************************/

package uk.co.grahamcox.ccg.webapp.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

/**
 * Steps for working with authentication
 */
public class AuthenticationSteps {
    /**
     * Record that we are authenticated as a given user
     * @param userId the user to authenticate as
     */
    @Given("^that I am authenticated as user \"(.+)\"$")
    public void authenticateAsUser(String userId) {
        throw new PendingException();
    }
}
