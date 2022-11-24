package nl.sogyo.pvsluis.rummikub.api;

import jakarta.servlet.http.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import nl.sogyo.pvsluis.rummikub.api.models.RummikubDTO;
import nl.sogyo.pvsluis.rummikub.api.models.SpeelSteenDTO;
import nl.sogyo.pvsluis.rummikub.domain.Rummikub;

@Path("/speel")
public class SpeelSteen {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response speel(
            @Context HttpServletRequest request,
            SpeelSteenDTO speel) {
        HttpSession session = request.getSession(true);

        Rummikub rummikub = (Rummikub) session.getAttribute("rummikub");

        rummikub.speelSteen(
                speel.getBronContainerIndex(),
                speel.getSteenIndex(),
                speel.getDoelContainerIndex());

        RummikubDTO output = new RummikubDTO(rummikub);

        return Response.status(200).entity(output).build();
    }
}
