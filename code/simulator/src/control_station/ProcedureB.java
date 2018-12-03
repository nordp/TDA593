package control_station;

import model.Status;

import java.util.Collection;

/**
 * Created by svante on 2018-12-01.
 */
public class ProcedureB implements Procedure {
    @Override
    public Procedure update(Collection<Status> robots) {
        return null;
    }

    @Override
    public int calculate(Collection<Status> robots) {
        return 0;
    }
}
