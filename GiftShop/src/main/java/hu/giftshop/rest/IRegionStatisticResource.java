package hu.giftshop.rest;

import hu.giftshop.dto.RegionStatisticDTO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("regionstatistics")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface IRegionStatisticResource {
    
    @GET
    public List<RegionStatisticDTO> getRegionStatistics();

}
