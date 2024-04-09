package org.pahappa.systems.kimanyisacco.services.impl;

import org.pahappa.systems.kimanyisacco.services.ReconcilationStrategy;

public class ReconcilationManager {
    private ReconcilationStrategy reconcilationStrategy;

    public void setReconcilationStrategy(ReconcilationStrategy reconcilationStrategy){
        this.reconcilationStrategy = reconcilationStrategy;
    }

    public void reconcileAccount(Object obj){
        if (reconcilationStrategy != null){
            reconcilationStrategy.reconcile(obj);
        } else{
            System.out.println("No reconcile strategy set");
        }
    }
}
