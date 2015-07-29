/****************************************************************************************************************
 * Copyright (c) 2015 OCLC, Inc. All Rights Reserved.
 *
 * OCLC proprietary information: the enclosed materials contain
 * proprietary information of OCLC, Inc. and shall not be disclosed in whole or in
 * any part to any third party or used by any person for any purpose, without written
 * consent of OCLC, Inc.  Duplication of any portion of these materials shall include this notice.
 ******************************************************************************************************************/

package uk.co.grahamcox.ccg.webapp.cucumber.steps;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.web.WebAppConfiguration;
import uk.co.grahamcox.ccg.spring.CoreConfig;
import uk.co.grahamcox.ccg.webapp.spring.WebappConfig;

/**
 * Base class to use for steps, to group the common config together
 */
@ActiveProfiles("test")
@ContextHierarchy({
    @ContextConfiguration(classes = {
        CoreConfig.class,
        WebappConfig.class
    })
})
@WebAppConfiguration
public abstract class StepBase {
}
