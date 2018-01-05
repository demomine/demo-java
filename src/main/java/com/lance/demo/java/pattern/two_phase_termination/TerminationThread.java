package com.lance.demo.java.pattern.two_phase_termination;

public abstract class TerminationThread extends Thread implements Terminatable {
    protected final TerminationToken terminationToken;

    public TerminationThread() {
        this(new TerminationToken());
    }

    public TerminationThread(TerminationToken terminationToken) {
        this.terminationToken = terminationToken;
        this.setDaemon(true);
        terminationToken.register(this);
    }

    @Override
    public void run() {
        Exception ex = null;
        try {
            while (true) {
                if (!terminationToken.isTerminated() && terminationToken.reservations.get() <= 0) {
                    doRun();
                }
            }
        } catch (Exception e) {
            ex = e;
        } finally {
            try {
                doCleanUp(ex);
            } finally {
                terminationToken.notifyTerminate(this);
            }
        }
    }

    @Override
    public void terminate() {
        terminationToken.setTerminated(true);
        try {
            doTerminate();
        } finally {
            if (terminationToken.reservations.get() <= 0) {
                super.interrupt();
            }
        }
    }

    public void terminate(boolean waitUntilThreadTerminated) {
        terminate();
        if (waitUntilThreadTerminated) {
            try {
                this.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    protected abstract void doTerminate();

    protected abstract void doCleanUp(Exception ex);

    protected abstract void doRun();
}
