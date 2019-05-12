package hu.giftshop.rest.impl;

import hu.giftshop.controller.RegionStatisticController;
import hu.giftshop.dto.RegionStatisticDTO;
import hu.giftshop.rest.IRegionStatisticResource;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;

@RequestScoped
public class RegionStatisticResourceImpl implements IRegionStatisticResource {

    @EJB
    private RegionStatisticController regionStatisticController;
    
    
    @Override
    public List<RegionStatisticDTO> getRegionStatistics() {
        return regionStatisticController.getRegionStatistics();
    }
}
