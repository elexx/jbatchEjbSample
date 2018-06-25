package com.github.elexx.jbatchejbsample.ejb;

import javax.ejb.Remote;

@Remote
public interface Connector {

    long getCurrentTime();

}
