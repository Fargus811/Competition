package com.gmail.ggas.repository.impl;

import com.gmail.ggas.entity.Subscription;
import com.gmail.ggas.repository.SubscriptionRepository;

public class InMemorySubscriptionRepository extends BaseRepository<Subscription> implements SubscriptionRepository {

    private final static int ID_INDEX = 0;

    private final static int SPORTSMAN_ID_INDEX = 1;

    private final static int TRAININGS_NUMBER_INDEX = 2;

    public InMemorySubscriptionRepository(String relativePath) {
        super(relativePath);
    }

    private static InMemorySubscriptionRepository instance;

    public static InMemorySubscriptionRepository getInstance() {
        if (instance == null) {
            instance = new InMemorySubscriptionRepository("database/subscription.txt");
        }

        return instance;
    }

    //TODO think about subscription
    @Override
    protected String buildLine(Subscription entity) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(entity.getId()).append(";").append(entity.getSportsmanId()).append(";")
                .append(entity.getNumberOfClasses());
        return stringBuilder.toString();
    }

    @Override
    protected Subscription buildEntity(String line) {
        String[] coachParts = line.split(";");
        Subscription subscriptionResult = new Subscription();
        subscriptionResult.setId(Long.parseLong(coachParts[ID_INDEX]));
        subscriptionResult.setSportsmanId(Long.parseLong(coachParts[SPORTSMAN_ID_INDEX]));
        subscriptionResult.setNumberOfClasses(Integer.parseInt(coachParts[TRAININGS_NUMBER_INDEX]));
        return subscriptionResult;
    }


}
