package com.bskm.springboot.model;

public class RewardPoints {
	double purchasedAmount;
	int rewardPoints;

	public RewardPoints() {
		// TODO Auto-generated constructor stub
	}

	public double getPurchasedAmount() {
		return purchasedAmount;
	}

	public void setPurchasedAmount(double purchasedAmount) {
		this.purchasedAmount = purchasedAmount;
	}

	public int getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public RewardPoints(double purchasedAmount, int rewardPoints) {
		this.purchasedAmount = purchasedAmount;
		this.rewardPoints = rewardPoints;
	}

}
