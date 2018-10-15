package ua.skillsup.practice.jpaworkshop.service.impl;

import org.springframework.stereotype.Service;
import ua.skillsup.practice.jpaworkshop.dao.ItemRepository;
import ua.skillsup.practice.jpaworkshop.dao.entity.Item;
import ua.skillsup.practice.jpaworkshop.dao.entity.Lot;
import ua.skillsup.practice.jpaworkshop.dao.entity.LotHistory;
import ua.skillsup.practice.jpaworkshop.dao.entity.User;
import ua.skillsup.practice.jpaworkshop.service.AuctionService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class AuctionServiceImpl implements AuctionService {

	private final ItemRepository itemRepository;

	public AuctionServiceImpl(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}

	@Override
	public User getUser(String login) {
		return null;
	}

	@Override
	public List<Lot> getUserLots(String login, LocalDate from, LocalDate to) {
		return null;
	}

	@Override
	public List<Lot> getAllLots() {
		return null;
	}

	@Override
	public Lot createLot(String login, String item, BigDecimal startPrice, int period) {
		return null;
	}

	@Override
	public void makeBid(String login, long lotId, BigDecimal newPrice) {

	}

	@Override
	public List<LotHistory> getLotHistory(long lotId) {
		return null;
	}
}
