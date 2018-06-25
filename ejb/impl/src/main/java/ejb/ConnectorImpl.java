package ejb;

import com.github.elexx.jbatchejbsample.ejb.Connector;

import javax.ejb.Stateless;

@Stateless
public class ConnectorImpl implements Connector {

    public long getCurrentTime() {
        System.out.println("getCurrentTime got called");

        return System.currentTimeMillis();
    }
}
