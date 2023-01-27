package nl.sogyo.pvsluis.rummikub.api;

import jakarta.servlet.http.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import nl.sogyo.pvsluis.rummikub.api.models.RummikubDTO;
import nl.sogyo.pvsluis.rummikub.domain.Rummikub;

@Path("/paneel")
public class PaneelActie {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response paneel(
            @Context HttpServletRequest request,
            int actieIndex) {
        HttpSession session = request.getSession(true);

        Rummikub rummikub = (Rummikub) session.getAttribute("rummikub");

        switch (actieIndex) {
            case 0:
                rummikub.resetSpelNaarAanvangBeurt();
                break;
            case 1:
                rummikub.sluitBeurtAf();
                break;
            case 2:
                rummikub.neemSteenUitPot();
                break;
            case 3:
                rummikub.sorteerPlankjeOpCijfer();
                break;
            case 4:
                rummikub.sorteerPlankjeOpKleur();
                break;
            default:
                System.out.println("Paneelactie " + actieIndex
                        + " niet herkend. Wordt genegeerd.");
        }

        RummikubDTO output = new RummikubDTO(rummikub);

        return Response.status(200).entity(output).build();
    }
}
