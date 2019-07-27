package ua.skillsup.practice.jpaworkshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import ua.skillsup.practice.jpaworkshop.service.AuctionService;

@ImportResource("classpath:/spring/db-context.xml")
@SpringBootApplication
public class JpaWorkshopApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				SpringApplication.run(JpaWorkshopApplication.class, args);
//		ItemRepository itemRepository = context.getBean(ItemRepository.class);
//		System.out.println(itemRepository.findAll());
//		System.out.println(itemRepository.findByTitle("Dinning table"));
//		System.out.println(itemRepository.findByWeightGreaterThen(0.05));
//
//		UserRepository userRepository = context.getBean(UserRepository.class);
//		System.out.println(userRepository.findAll());
//
//		LotRepository lotRepository = context.getBean(LotRepository.class);
//		System.out.println(lotRepository.findAll().size());
//		System.out.println(lotRepository.findByUserNameAndCreationDate("Odin",
//				LocalDate.now().minusDays(5), LocalDate.now().plusDays(1)
//		));
//
		AuctionService service = context.getBean(AuctionService.class);
//		System.out.println(service.createLot("Loki", "Dinning table",
//				BigDecimal.valueOf(555), 10));
//
//		System.out.println(lotRepository.findAll().size());
		System.out.println(service.getItemsByCategory("Digital"));
	}
}
