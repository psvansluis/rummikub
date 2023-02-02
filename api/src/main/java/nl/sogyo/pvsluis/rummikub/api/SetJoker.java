package nl.sogyo.pvsluis.rummikub.api;

import jakarta.servlet.http.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import nl.sogyo.pvsluis.rummikub.api.models.RummikubDTO;
import nl.sogyo.pvsluis.rummikub.api.models.SetJokerDTO;
import nl.sogyo.pvsluis.rummikub.domain.Rummikub;

@Path("/joker")
public class SetJoker {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response set(
            @Context HttpServletRequest request,
            SetJokerDTO set) {
        HttpSession session = request.getSession(true);

        Rummikub rummikub = (Rummikub) session.getAttribute("rummikub");

        rummikub.setJokerWaarde(
                set.getContainerIndex(),
                set.getSteenIndex(),
                set.getCijfer(),
                set.getKleur());

        RummikubDTO output = new RummikubDTO(rummikub);

        return Response.status(200).entity(output).build();
    }
}
