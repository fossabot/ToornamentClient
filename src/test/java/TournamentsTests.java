import static org.junit.Assert.*;

import com.toornament.ToornamentClient;
import com.toornament.model.Stream;
import com.toornament.model.Tournament;
import com.toornament.model.TournamentDetails;
import com.toornament.model.enums.MatchFormat;
import com.toornament.model.enums.ParticipantType;
import com.toornament.model.enums.Platforms;
import com.toornament.model.enums.Scope;
import com.toornament.model.request.TournamentQuery;
import com.toornament.model.request.TournamentRequest;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TournamentsTests {
    private ToornamentClient client;
    private TournamentQuery.TournamentQueryBuilder params = TournamentQuery.builder();
    private HashMap<String,String> headers;
    private HashSet<Scope> scopes = new HashSet<>();
    private TournamentRequest tournamentRequest = new TournamentRequest();
    private TournamentDetails tournamentDetails = new TournamentDetails();
    @Before
    public void Setup() throws IOException {
        scopes.add(Scope.USER_INFO);
        client = new ToornamentClient(System.getenv("KEY"),System.getenv("CLIENT"),System.getenv("SECRET"),
            scopes);
        client.authorize();

        headers = new HashMap<>();
    params
        .discipline("overwatch")
        .isOnline(false)
        .scheduledAfter(LocalDate.parse("2018-09-04"))
        .scheduledBefore(LocalDate.parse("2019-04-05"))
        .platform(Platforms.PC);

        tournamentDetails.setParticipantType(ParticipantType.TEAM);
        tournamentDetails.setName("OWL Season 1 TEST");
        tournamentDetails.setSize(144);
        tournamentDetails.setDiscipline("overwatch");

        tournamentRequest.setName("OWL Season 1 TEST");
        tournamentRequest.setDiscipline("overwatch");
        tournamentRequest.setOrganization("Blizzard Entertainment");
        tournamentRequest.setWebsite("http://www.overwatchleague.com");
        tournamentRequest.setMatchFormat(MatchFormat.BO3);
        tournamentRequest.setIsPublic(false);
        tournamentRequest.setPrize("1 - $10,000 \n 2 - $5,000");
        tournamentRequest.setSize(144);
        tournamentRequest.setParticipantType(ParticipantType.TEAM);
        tournamentRequest.setTimezone("America/Los_Angeles");
        tournamentRequest.setCountry("US");
        tournamentRequest.setDateStart(LocalDate.parse("2018-09-05",DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        tournamentRequest.setDateEnd(LocalDate.parse("2019-04-05",DateTimeFormatter.ofPattern("yyyy-MM-dd")));


    }

    @Test
    public void getFeaturedTournamentsTest() {
            headers.put("range","tournaments=0-49");
            List<Tournament> details = client.tournamentsV2().getFeaturedTournaments(params.build(),headers);

            ArrayList<Tournament> list = new ArrayList<>(details);
    System.out.println(list);
        assertFalse(list.isEmpty());
    }

//    @Test
//    public void getTournamentTest(){
//
//        Tournament tournament = client.tournamentsV2().getTournament("906278647555784704");
//    System.out.println(tournament);
//        assertTrue("overwatch".matches(tournament.getDiscipline()));
//    }

    @Test //need new tournament id with streams
    public void getStreamsTest(){
        Map<String,String> range = new HashMap<>();
        range.put("range","streams=0-5");
        List<Stream> streams = client.tournamentsV2().getStreams("906278647555784704", range);
        System.out.println(streams);
        assertEquals(4,streams.size());
    }

}
