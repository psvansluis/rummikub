package nl.sogyo.pvsluis.rummikub.api;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import jakarta.servlet.http.*;
import jakarta.ws.rs.core.*;
import nl.sogyo.pvsluis.rummikub.api.models.RummikubDTO;
import nl.sogyo.pvsluis.rummikub.api.models.SetJokerDTO;
import nl.sogyo.pvsluis.rummikub.api.models.SpeelSteenDTO;
import nl.sogyo.pvsluis.rummikub.domain.Rummikub;

public class SpeelRummikubTest {
    private HttpServletRequest request;
    private HttpSession session;

    private SpeelSteenDTO speelSteen(
            int bronContainerIndex, int steenIndex, int doelContainerIndex) {
        SpeelSteenDTO input = new SpeelSteenDTO();
        input.setBronContainerIndex(bronContainerIndex);
        input.setSteenIndex(steenIndex);
        input.setDoelContainerIndex(doelContainerIndex);
        return input;
    }

    private SetJokerDTO setJoker(
            int containerIndex, int steenIndex, int cijfer, int kleur) {
        SetJokerDTO input = new SetJokerDTO();
        input.setContainerIndex(containerIndex);
        input.setSteenIndex(steenIndex);
        input.setCijfer(cijfer);
        input.setKleur(kleur);
        return input;
    }

    private HttpServletRequest createRequestContext(Rummikub r) {
        request = mock(HttpServletRequest.class);
        session = mock(HttpSession.class);
        when(request.getSession(true)).thenReturn(session);
        when(session.getAttribute("rummikub")).thenReturn(r);
        return request;
    }

    @Test
    public void eersteSteenNaarSets() {
        Rummikub r = new Rummikub(new ArrayList<String>() {
            {
                add("Henk");
            }
        }, 2);
        SpeelSteen s = new SpeelSteen();
        Response respons = s.speel(
                createRequestContext(r),
                speelSteen(-1, 0, 0));

        RummikubDTO entiteit = (RummikubDTO) respons.getEntity();
        assertEquals(1, entiteit.getSets().length);
    }

    @Test
    public void manipuleerJoker() {
        Rummikub r = new Rummikub(new ArrayList<String>() {
            {
                add("Henk");
            }
        }, 9);
        SetJoker s = new SetJoker();
        Response respons = s.set(
                createRequestContext(r),
                setJoker(-1, 10, 5, 2));

        RummikubDTO entiteit = (RummikubDTO) respons.getEntity();
        assertEquals(5, entiteit.getPlankje().getStenen()[10].getCijfer());
    }
}
