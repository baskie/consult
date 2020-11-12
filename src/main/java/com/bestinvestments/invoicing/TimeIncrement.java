package com.bestinvestments.invoicing;

public class TimeIncrement {
    Double value;

    public Integer timeIncrement(Integer t)
    {
        value = (Math.ceil(t/15)*15);
        return value.intValue();
    }

    public TimeIncrement add(TimeIncrement t)
    {
        return new TimeIncrement(value + t.timeIncrement(t));
    }

}
