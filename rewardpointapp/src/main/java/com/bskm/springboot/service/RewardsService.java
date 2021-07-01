package com.bskm.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.bskm.springboot.exception.InvalidAmountException;
import com.bskm.springboot.model.RewardPoints;

@Service
public class RewardsService implements IRewardsService {

	private static final Logger logger = LoggerFactory.getLogger(RewardsService.class);

	@Override
	public RewardPoints calculateRewardsPoints(@RequestParam double purchasedAmount) throws InvalidAmountException {

		logger.info("Calculating Rewards Method Started");

		if (purchasedAmount <= 0) {

			logger.warn("Enter Purchased Amount Greaterthan Zero: " + purchasedAmount);
			throw new InvalidAmountException("Enter the amount greaterthan Zero: " + purchasedAmount);
		}

		int amount = (int) Math.ceil(purchasedAmount);
		int rewardPoints = 0;

		try {
			if (amount <= 50) {
				rewardPoints = 0;
			} else if (amount > 50 && amount <= 100) {
				rewardPoints = rewardPoints + (amount - 50) * 1;
			} else if (amount > 100) {
				rewardPoints = 50 * 1 + (amount - 100) * 2;
			}
		} catch (Exception e) {

			logger.error("Enter Valid Purchased Amount: " + purchasedAmount);
			throw new InvalidAmountException("Entered Amount is not valid: " + purchasedAmount + e.getMessage());
		}

		logger.info("Calculating Rewards Method Ended");

		return new RewardPoints(purchasedAmount, rewardPoints);
	}
}
