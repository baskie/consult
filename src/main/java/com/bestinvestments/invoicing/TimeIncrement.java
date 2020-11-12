package com.bestinvestments.invoicing;

public class TimeIncrement {
    Double value;

    public TimeIncrement(double v) {
    }

    public Double timeIncrement(Integer t)
    {
        value = (Math.ceil(t/15)*15);
        //return value.intValue();
        return value;
    }

    public TimeIncrement add(TimeIncrement t)
    {
        return new TimeIncrement(value + t.value);
    }
    public Boolean moreThan(TimeIncrement t)
    {
        Boolean isGreater = Math.abs(t.value)>Math.abs(value);
        return isGreater;
    }
}
