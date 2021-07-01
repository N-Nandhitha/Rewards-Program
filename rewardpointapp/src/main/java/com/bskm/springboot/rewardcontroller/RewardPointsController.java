package com.bskm.springboot.rewardcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bskm.springboot.exception.InvalidAmountException;
import com.bskm.springboot.model.RewardPoints;
import com.bskm.springboot.service.IRewardsService;

@RestController
@RequestMapping("/rewards")
public class RewardPointsController {

	@Autowired
	IRewardsService rewardsService;

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(RewardPointsController.class);

	@GetMapping("/calculate")
	public RewardPoints calculateRewardsPoints(@RequestParam double purchasedAmount) throws InvalidAmountException {

		logger.info("Calculating Rewards by Multiplying the purchased amount:" + purchasedAmount);

		RewardPoints rewards = rewardsService.calculateRewardsPoints(purchasedAmount);
		return rewards;
	}
}