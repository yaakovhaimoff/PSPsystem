package routing;

import Models.Transaction;

public interface RoutingService {
    public Transaction assignPSP(Transaction transaction);
}
