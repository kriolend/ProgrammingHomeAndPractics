package ua.org.oa.rumyancevv.practics8.transform;

import ua.org.oa.rumyancevv.practics8.model.dto.HumanDTO;
import ua.org.oa.rumyancevv.practics8.model.entity.Human;

/**
 * Created by dmitr on 01.03.2016.
 */
public class Transformer {
    public static Human transformHumanDTO(HumanDTO humanDTO) {
        Human human = new Human();

        human.setId(humanDTO.getId());
        human.setName(humanDTO.getName());
        human.setAge(humanDTO.getAge());
        return human;
    }

    public static HumanDTO transformHuman( Human human) {

        HumanDTO humanDTO = new HumanDTO();

        humanDTO.setId(human.getId());
        humanDTO.setName(human.getName());
        humanDTO.setAge(human.getAge());

        return humanDTO;
    }
}
