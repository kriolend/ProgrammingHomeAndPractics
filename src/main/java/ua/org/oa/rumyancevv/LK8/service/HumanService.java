package ua.org.oa.rumyancevv.LK8.service;

import ua.org.oa.rumyancevv.LK8.model.dto.HumanDTO;
import ua.org.oa.rumyancevv.LK8.model.entity.Human;

/**
 * Created by user on 03.03.2016.
 */
public interface HumanService {
    public HumanDTO findHumanById(int id);

    public Human createHuman(HumanDTO humanDTO);
}
