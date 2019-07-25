package ua.skillsup.practice.jpaworkshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import ua.skillsup.practice.jpaworkshop.dao.ItemRepository;
import ua.skillsup.practice.jpaworkshop.dao.LotRepository;
import ua.skillsup.practice.jpaworkshop.dao.entity.Item;
import ua.skillsup.practice.jpaworkshop.dao.entity.Lot;
import ua.skillsup.practice.jpaworkshop.service.AuctionService;

import java.time.LocalDate;
import java.util.List;

@ImportResource("classpath:/spring/db-context.xml")
@SpringBootApplication
public class JpaWorkshopApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JpaWorkshopApplication.class, args);

		AuctionService service = context.getBean(AuctionService.class);

		System.out.println(service.getAllItems());

		ItemRepository repository = context.getBean(ItemRepository.class);
		System.out.println(repository.findByTitle("Dinning table"));
		Item item = new Item();
		item.setTitle("Titleee");
		item.setId(1112L);
		item.setDescription("Desscccrrrrppp");
		repository.create(item);


		System.out.println(service.getAllItems());

//		System.out.println(repository.findByWeightGreaterThen(0.1));
//		LotRepository lotRepository = context.getBean(LotRepository.class);
//		System.out.println(lotRepository.findAll());
//
//		List<Lot> lots = lotRepository
//				.findByUserNameAndCreationDate("Odin",
//						LocalDate.now().minusDays(1),
//						LocalDate.now().plusDays(1));
//		System.out.println(lots);
	}
}
