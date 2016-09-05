package ua.org.oa.rumyancevv.practics8.service;

import ua.org.oa.rumyancevv.practics8.model.dto.HumanDTO;
import ua.org.oa.rumyancevv.practics8.model.entity.Human;

/**
 * Created by dmitr on 01.03.2016.
 */
public interface HumanService {
    public HumanDTO findHumanById(int id);

    public Human createHuman(HumanDTO humanDTO);
}
