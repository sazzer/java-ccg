package uk.co.grahamcox.ccg.webapp.leaderboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import uk.co.grahamcox.ccg.webapp.types.LeaderboardEntryType;
import uk.co.grahamcox.ccg.webapp.types.LeaderboardType;
import uk.co.grahamcox.ccg.webapp.types.UserLinkType;

import java.util.UUID;

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
    public LeaderboardType getLeaderboard(
        @RequestParam(value = "offset", required = false, defaultValue = "0") final int offset,
        @RequestParam(value = "count", required = false, defaultValue = "10") final int count) {

        LeaderboardEntryType entry = new LeaderboardEntryType();
        entry.setRank(1);
        entry.setScore(12345);
        entry.setUser(new UserLinkType());
        entry.getUser().setId(UUID.randomUUID().toString());
        entry.getUser().setName("Graham");

        LeaderboardType leaderboard = new LeaderboardType();
        leaderboard.getEntries().add(entry);
        leaderboard.setTotalResults(200);
        return leaderboard;
    }
}
