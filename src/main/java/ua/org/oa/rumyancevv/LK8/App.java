package ua.org.oa.rumyancevv.LK8;

import ua.org.oa.rumyancevv.LK8.model.dto.HumanDTO;
import ua.org.oa.rumyancevv.LK8.service.DatabaseService;
import ua.org.oa.rumyancevv.LK8.service.HumanService;
import ua.org.oa.rumyancevv.LK8.service.impl.HumanServiceImpl;

/**
 * Created by user on 28.02.2016.
 */
public class App {
    public static void main(String[] args) {
        //        String url = "jdbc:mysql://localhost:3306/test";
//        String user = "root";
//        String password = "123";
//        List<Human> humanList = new ArrayList<>();
//        try (Connection connection = DriverManager.getConnection(url, user, password);
//        Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//             PreparedStatement prs = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
//             ResultSet rs = st.executeQuery("SELECT * FROM HUMAN");
//        ){
//
//            prs.setString(1, "Misha");
//            prs.setInt(2, 15);
//
//            prs.executeUpdate();
//            ResultSet sr = prs.getGeneratedKeys();
//            if(sr.next()) System.out.println(sr.getInt(1));
//
//            Human human = null;
//
//            while (rs.next()){
//                human = new Human();
//                human.setId(rs.getInt("id"));
//                human.setName(rs.getString(2));
//                human.setAge(rs.getInt("age"));
//                humanList.add(human);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        humanList.forEach(System.out::println);


        DatabaseService.initDatabase();
//        Dao<Human> humanDao = new HumanDao();
//
//        Human vasya = new Human();
//        vasya.setName("Vasya");
//        vasya.setAge(25);
//        System.out.println(vasya);
//        humanDao.create(vasya);
//        System.out.println(vasya);
//        humanDao.getAll().forEach(System.out::println);

        HumanService humanService = HumanServiceImpl.getInstance();

        humanService.createHuman(new HumanDTO("Vasya", 25));
        humanService.createHuman(new HumanDTO("Potya", 30));

        System.out.println(humanService.findHumanById(1));
        System.out.println(humanService.findHumanById(2));
    }
}