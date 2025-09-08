package br.com.mariojp.solid.ocp;

import java.util.HashMap;
import java.util.Map;

public class DiscountCalculator {
    private final Map<CustomerType, DiscountPolicy> discountPolicies;

    public DiscountCalculator(Map<CustomerType, DiscountPolicy> discountPolicies) {
        if (discountPolicies == null) {
            this.discountPolicies = new HashMap<>();
            this.discountPolicies.put(CustomerType.PARTNER, amount -> amount * 0.88);
        } else {
            this.discountPolicies = discountPolicies;
        }
    }

    public double apply(double amount, CustomerType type) {
        DiscountPolicy policy = discountPolicies.get(type);
        if (policy == null) {
            return amount;
        }
        return policy.apply(amount);
    }
}