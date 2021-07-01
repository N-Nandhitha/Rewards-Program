package com.bskm.springboot.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.bskm.springboot.exception.InvalidAmountException;
import com.bskm.springboot.model.RewardPoints;

@Service
public interface IRewardsService {
	public RewardPoints calculateRewardsPoints(@RequestParam double purchasedAmount) throws InvalidAmountException;
}
