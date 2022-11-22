package nl.sogyo.pvsluis.rummikub.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import static org.mockito.Mockito.*;

import jakarta.servlet.http.*;
import jakarta.ws.rs.core.*;
import nl.sogyo.pvsluis.rummikub.api.models.RummikubDTO;
import nl.sogyo.pvsluis.rummikub.api.models.SpelerInputDTO;

public class StartRummikubTest {
    private HttpServletRequest request;
    private HttpSession session;

    private String[] beginSpelers() {
        return new String[] { "Henk", "Toos", "Huub" };
    }

    private SpelerInputDTO spelerInput() {
        SpelerInputDTO input = new SpelerInputDTO();
        input.setSpelerNamen(beginSpelers());
        return input;
    }

    private HttpServletRequest createRequestContext() {
        request = mock(HttpServletRequest.class);
        session = mock(HttpSession.class);
        when(request.getSession(true)).thenReturn(session);
        return request;
    }

    private Response startRummikub() {
        StartRummikub servlet = new StartRummikub();
        HttpServletRequest request = createRequestContext();
        SpelerInputDTO input = spelerInput();
        System.out.print(request);
        System.out.print(input);

        return servlet.start(request, input);
    }

    @Test
    public void eenRummikubMagGestartWorden() {
        Response respons = startRummikub();
        assertEquals(200, respons.getStatus());
    }

    @Test
    public void eenRummikubGeefteenPlankjeTerugMet14Stenen() {
        Response respons = startRummikub();
        RummikubDTO entiteit = (RummikubDTO) respons.getEntity();
        assertEquals(14, entiteit.getPlankje().getStenen().length);
    }

    @Test
    public void eenSteenOpPlankjeHeeftEenCijferVan1OfHoger() {
        Response respons = startRummikub();
        RummikubDTO entiteit = (RummikubDTO) respons.getEntity();
        assertTrue(0 < entiteit.getPlankje().getStenen()[0].getCijfer());
    }

}
