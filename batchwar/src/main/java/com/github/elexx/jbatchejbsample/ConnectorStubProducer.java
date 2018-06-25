package com.github.elexx.jbatchejbsample;

import com.github.elexx.jbatchejbsample.ejb.Connector;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.util.Objects;

@ApplicationScoped
public class ConnectorStubProducer {

    @EJB(lookup = "com.github.elexx.jbatchejbsample.ejb.Connector")
    private Connector connector;

    @Produces
    @ApplicationScoped
    public Connector create() {
        return Objects.requireNonNull(connector, "Can not find implementation for interface " + Connector.class.getName());
    }
}
