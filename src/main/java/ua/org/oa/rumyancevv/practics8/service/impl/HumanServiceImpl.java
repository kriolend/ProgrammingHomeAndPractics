package ua.org.oa.rumyancevv.practics8.service.impl;

import ua.org.oa.rumyancevv.practics8.dao.implJdbc.HumanDao;
import ua.org.oa.rumyancevv.practics8.model.dto.HumanDTO;
import ua.org.oa.rumyancevv.practics8.model.entity.Human;
import ua.org.oa.rumyancevv.practics8.properties.PropertyUtils;
import ua.org.oa.rumyancevv.practics8.service.HumanService;
import ua.org.oa.rumyancevv.practics8.transform.Transformer;

import java.util.Properties;

/**
 * Created by dmitr on 01.03.2016.
 */
public class HumanServiceImpl implements HumanService {

    private static HumanService humanService;

    private HumanServiceImpl() {
    }

    private HumanDao humanDAO = fetchDAO();


    @Override
    public HumanDTO findHumanById(int id) {
        Human humanById = humanDAO.getById(id);
        HumanDTO humanDTO = Transformer.transformHuman(humanById);
        return humanDTO;
    }

    @Override
    public Human createHuman(HumanDTO humanDTO) {
        Human human = Transformer.transformHumanDTO(humanDTO);
        return humanDAO.create(human);
    }

    private HumanDao fetchDAO() {
        HumanDao humanDAO = null;
            Properties properties = PropertyUtils.getProperties();
            String value = properties.getProperty("DB");
           switch (value) {
               case "JDBC":
                   humanDAO = new HumanDao();
                   break;
           }
        return humanDAO;
    }


    public synchronized static HumanService getInstance() {
        if (humanService == null) {
            humanService = new HumanServiceImpl();
        }
        return humanService;
    }
}