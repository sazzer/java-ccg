package uk.co.grahamcox.ccg.webapp.leaderboard;

import java.util.Arrays;
import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller for loading the Leaderboard details
 */
@Controller
@RequestMapping("/api/leaderboard")
public class LeaderboardController {
    /**
     * Get the leaderboard
     * @param offset The offset into the leaderboard to return
     * @param count The number of results on the leaderboard to return
     * @return the requested page of results
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @SuppressWarnings("checkstyle:magicnumber")
    public PagedList<LeaderboardEntry> getLeaderboard(
        @RequestParam(value = "offset", required = false, defaultValue = "0") final int offset,
        @RequestParam(value = "count", required = false, defaultValue = "10") final int count) {
        return new PagedList<>(Arrays.asList(
            new LeaderboardEntry(new UserLink(UUID.randomUUID().toString(), "Graham"), 12345),
            new LeaderboardEntry(new UserLink(UUID.randomUUID().toString(), "Fred"), 1234),
            new LeaderboardEntry(new UserLink(UUID.randomUUID().toString(), "George"), 123),
            new LeaderboardEntry(new UserLink(UUID.randomUUID().toString(), "Harry"), 12),
            new LeaderboardEntry(new UserLink(UUID.randomUUID().toString(), "Simon"), 1)
        ), 200);
    }
}
